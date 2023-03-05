package net.absoft.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.testng.Assert.assertTrue;

public class CartPage extends BaseStorePage {

    private final String ItemXPath = "//div[@class='cart_item_label'][.//div[@class='inventory_item_name' and text() = '%s']]";


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
}
