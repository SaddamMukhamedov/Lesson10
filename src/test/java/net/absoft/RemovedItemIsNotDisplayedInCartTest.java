package net.absoft;

import io.qameta.allure.Description;
import net.absoft.data.Account;
import net.absoft.pages.InventoryPage;
import net.absoft.pages.LoginPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RemovedItemIsNotDisplayedInCartTest extends BaseTest{

    private final String ITEM = "Sauce Labs Backpack";
    private final String FIRST_NAME = "Saddam";
    private final String LAST_NAME = "Mukhamedov";
    private final String ZIP_CODE = "90011";

    private InventoryPage inventoryPage;

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
                .getBackToShopping();
    }

    @Test
    @Description("Check that item was not added to cart while payment")
    public void RemovedItemIsNotInCart() {


        inventoryPage
                .removeItemFromCart(ITEM)
                .openCart()
                .checkItemAbsense(ITEM)
                .checkoutButton()
                .inputFirstName(FIRST_NAME)
                .inputLastName(LAST_NAME)
                .inputPostalCode(ZIP_CODE)
                .continueButton()
                .checkItemAbsence(ITEM);

    }
}
