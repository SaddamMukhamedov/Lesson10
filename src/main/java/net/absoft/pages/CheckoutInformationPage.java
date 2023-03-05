package net.absoft.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.testng.Assert.assertTrue;

public class CheckoutInformationPage extends BaseComponent{
    public CheckoutInformationPage(WebDriver driver) {
        super(driver);
    }
    private final WebElement INPUT_FIRST_NAME = driver.findElement(By.xpath("//input[@data-test='firstName']"));
    private final WebElement INPUT_LAST_NAME = driver.findElement(By.xpath("//input[@data-test='lastName']"));
    private final WebElement INPUT_POSTAL_CODE = driver.findElement(By.xpath("//input[@data-test='postalCode']"));
    private final WebElement CONTINUE_BUTTON = driver.findElement(By.xpath("//input[@data-test='continue']"));
    private final WebElement CANCEL_BUTTON = driver.findElement(By.xpath("//button[@data-test='cancel']"));


    @Step("Check that the Checkout information page is opened")
    public CheckoutInformationPage shouldBeOnPage() {

        assertTrue(!driver.findElements(By.xpath("//span[text()='Checkout: Your Information']")).isEmpty()
                        && driver.findElement(By.xpath("//span[text()='Checkout: Your Information']")).isDisplayed(),
                "User is not on the checkout information page");
        return this;
    }

    @Step("Input valid first name")
    public CheckoutInformationPage inputFirstName (String firstName) {
       WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        wait.until(ExpectedConditions.visibilityOf(INPUT_FIRST_NAME));
        INPUT_FIRST_NAME.sendKeys(firstName);

        return this;
    }
    @Step("Input valid lasst name")
    public CheckoutInformationPage inputLastName (String lastName) {
        INPUT_LAST_NAME.sendKeys(lastName);

        return this;
    }
    @Step("Input valid postal code")
    public CheckoutInformationPage inputPostalCode (String zipCode) {
        INPUT_POSTAL_CODE.sendKeys(zipCode);

        return this;
    }
    @Step("Click on the continue button")
    public CheckoutOverviewPage continueButton () {
        CONTINUE_BUTTON.click();

        return new CheckoutOverviewPage(driver);
    }

    @Step("Click on the cancel button")
    public CheckoutInformationPage cancelCheckout () {
        CANCEL_BUTTON.click();

        return this;
    }

}
