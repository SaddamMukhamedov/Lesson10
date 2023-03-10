package net.absoft.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class InventoryPage extends BaseStorePage {
    private final String ItemXPath = "//div[@class='inventory_item'][.//div[@class='inventory_item_name' and text() = '%s']]";

    public InventoryPage(WebDriver driver) {
        super(driver);
    }



@Step("Adding item {itemName} to cart")
    public InventoryPage addItemToCart(String itemName) {
        WebElement item = driver.findElement(By.xpath(String.format(ItemXPath, itemName)));

        WebElement addToCartButton = item.findElement(By.xpath("//button[contains(@data-test, 'add-to-cart')]"));
        addToCartButton.click();
        return this;

    }



}
