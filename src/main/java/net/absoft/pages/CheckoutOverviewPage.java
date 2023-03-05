package net.absoft.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.testng.Assert.*;

public class CheckoutOverviewPage extends BaseComponent {

    public CheckoutOverviewPage(WebDriver driver) {
        super(driver);
    }

    private final WebElement FINISH_BUTTON = driver.findElement(By.xpath("//button[@data-test='finish']"));
    private final WebElement CANCEL_BUTTON = driver.findElement(By.xpath("//button[@data-test='cancel']"));
    private final String ItemXPath = "//div[@class='inventory_item_name' and text() = '%s']";


    @Step("Check that the 'Checkout overview' page is opened")
    public CheckoutOverviewPage shouldBeOnPage() {

        assertTrue(!driver.findElements(By.xpath("//span[text()='Checkout: Overview']")).isEmpty()
                        && driver.findElement(By.xpath("//span[text()='Checkout: Overview']")).isDisplayed(),
                "User is not on the checkout overview page");
        return this;
    }
    @Step("Check that the item displayed that was choosed on the Cart page")
    public CheckoutOverviewPage checkItemPresence(String itemName) {
        String itemXPathFormatted = String.format(ItemXPath, itemName);
        assertTrue(!driver.findElements(By.xpath(itemXPathFormatted)).isEmpty()
                        && driver.findElement(By.xpath(itemXPathFormatted)).isDisplayed(),
                "The " + itemName + " was not added to cart");
        return this;
    }
    // //div[@class='cart_item']
    @Step("Check that item was not added to cart on the checkout overview page")
    public CheckoutOverviewPage checkItemAbsence(String itemName) {
        String itemXPathFormatted = String.format(ItemXPath, itemName);
        assertTrue(driver.findElements(By.xpath(itemXPathFormatted)).isEmpty(),
                "The " + itemName + " was added to cart");
        return this;
    }
    @Step("Click on the cancel button")
    public CheckoutOverviewPage cancelCheckout () {
        CANCEL_BUTTON.click();

        return this;
    }
    @Step("Click on the finish button")
    public CheckoutCompletePage finishCheckout () {
        FINISH_BUTTON.click();

        return new CheckoutCompletePage(driver);
    }

}
