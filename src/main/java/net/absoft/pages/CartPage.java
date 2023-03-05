package net.absoft.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class CartPage extends BaseStorePage {

    private final String ItemXPath = "//div[@class='cart_item_label'][.//div[@class='inventory_item_name' and text() = '%s']]";
    private final WebElement CHECKOUT_BUTTON = driver.findElement(By.xpath("//button[@id='checkout']"));
    private final WebElement CONTINUE_SHOPPING_BUTTON = driver.findElement(By.xpath("//button[@data-test='continue-shopping']"));

    public CartPage(WebDriver driver) {
        super(driver);
    }



    //         WebElement item = driver.findElement(By.xpath(String.format(ItemXPath, itemName)));
    public CartPage checkItemPresence(String itemName) {
        String itemXPathFormatted = String.format(ItemXPath, itemName);
        assertTrue(!driver.findElements(By.xpath(itemXPathFormatted)).isEmpty()
                        && driver.findElement(By.xpath(itemXPathFormatted)).isDisplayed(),
                "The " + itemName + " was not added to cart");
            return this;
    }

    public CartPage checkItemAbsense(String itemName) {
        String itemXPathFormatted = String.format(ItemXPath, itemName);
        assertFalse(!driver.findElements(By.xpath(itemXPathFormatted)).isEmpty(),
                "The " + itemName + " was not added to cart");

        return this;
    }

    public CheckoutInformationPage checkoutButton() {
        CHECKOUT_BUTTON.click();
        return new CheckoutInformationPage(driver);
    }

    public CartPage getBackToShopping() {
        CONTINUE_SHOPPING_BUTTON.click();
        return this;
    }

}
