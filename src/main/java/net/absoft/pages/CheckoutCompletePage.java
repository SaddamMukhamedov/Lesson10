package net.absoft.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class CheckoutCompletePage extends BaseComponent{


    public CheckoutCompletePage(WebDriver driver) {
        super(driver);
    }

    private final String CHECKOUT_CONTAINER = "//div[@id='checkout_complete_container']";

    private final WebElement backHomeButton = driver.findElement(By.xpath("//button[@data-test='back-to-products']"));

    @Step("Check that the 'Checkout complete!' page is opened")
    public CheckoutCompletePage verificationCompletedCheckout() {

        assertTrue(!driver.findElements(By.xpath(CHECKOUT_CONTAINER)).isEmpty()
                        && driver.findElement(By.xpath(CHECKOUT_CONTAINER)).isDisplayed(),
                "User is not on the checkout complete page, the item was not purchased");
        return this;
    }
    @Step("Check that the user can get back to home")
    public CheckoutCompletePage goBackHome () {
        backHomeButton.click();
        assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/inventory.html", "The user can't get back to the inventory");
        return this;
    }



}
