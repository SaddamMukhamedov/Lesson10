package net.absoft;

import net.absoft.data.Account;
import net.absoft.pages.LoginPage;
import org.testng.annotations.Test;


public class LoginTest extends BaseTest{
    @Test(description = "Test successful login")
    public void testSuccessfulLogin() {
        new LoginPage(driver)
                .login(Account.STANDART_USER)
                .shouldSeePrimaryHeader();

    }
}
