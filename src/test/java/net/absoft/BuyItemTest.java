package net.absoft;

import io.qameta.allure.Description;
import net.absoft.data.Account;
import net.absoft.pages.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BuyItemTest extends BaseTest{

    private final String ITEM = "Sauce Labs Backpack";
    private final String FIRST_NAME = "Saddam";
    private final String LAST_NAME = "Mukhamedov";
    private final String ZIP_CODE = "90011";

    private InventoryPage inventoryPage;
    private CheckoutOverviewPage checkoutOverviewPage;
    private CheckoutInformationPage checkoutInformationPage;
    private CheckoutCompletePage checkoutCompletePage;

    @BeforeMethod
    public void setUp() {
        new LoginPage(driver)
                .login(Account.STANDART_USER)
                .shouldSeePrimaryHeader();
        inventoryPage = new InventoryPage(driver);

        inventoryPage
                .addItemToCart(ITEM)
                .openCart()
                .checkItemPresence(ITEM)
                .checkoutButton();
        checkoutInformationPage = new CheckoutInformationPage(driver);
    }


    @Test
    @Description ("Check that user can buy an item and get back to the home page")
    public void checkThatUserCanBuyAnItem() {
        checkoutInformationPage
                .shouldBeOnPage()
                .inputFirstName(FIRST_NAME)
                .inputLastName(LAST_NAME)
                .inputPostalCode(ZIP_CODE)
                .continueButton()
                .shouldBeOnPage()
                .checkItemPresence(ITEM)
                .finishCheckout()
                .verificationCompletedCheckout()
                .goBackHome();
        }
    }
