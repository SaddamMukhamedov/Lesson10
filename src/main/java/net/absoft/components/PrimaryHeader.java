package net.absoft.components;

import net.absoft.data.Account;
import net.absoft.pages.BaseComponent;
import net.absoft.pages.CartPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.testng.Assert.assertTrue;

public class PrimaryHeader extends BaseComponent {

    public final By SHOPPING_CART_LINK = By.className("shopping_cart_link");

    public PrimaryHeader(WebDriver driver) {
        super(driver);
    }

    public PrimaryHeader shouldSeePrimaryHeader() {
        assertTrue(!driver.findElements(SHOPPING_CART_LINK).isEmpty()
                        && driver.findElement(SHOPPING_CART_LINK).isDisplayed(),
                "User" + Account.STANDART_USER + " is not logged in");
        return this;
    }

    public CartPage openCart() {
        driver.findElement(SHOPPING_CART_LINK).click();
        return new CartPage(driver);
    }

}
