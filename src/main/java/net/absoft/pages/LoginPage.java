package net.absoft.pages;

import io.qameta.allure.Step;
import net.absoft.data.Account;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class LoginPage extends BaseComponent {


    public LoginPage(WebDriver driver) {
        super(driver);
    }


@Step("Perform login as {account.login} with password {account.password}")
    public InventoryPage login(Account account){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.findElement(By.cssSelector("input[data-test='username']"))
                .sendKeys(account.getLogin());
        driver.findElement(By.cssSelector("input[data-test='password']"))
                .sendKeys(account.getPassword());
        driver.findElement(By.cssSelector("input[data-test='login-button']"))
                .click();
        return new InventoryPage(driver);
    }


}
