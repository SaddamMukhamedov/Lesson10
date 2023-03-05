package net.absoft;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;


public abstract class BaseTest {
protected WebDriver driver;

    @BeforeSuite
    public void setUpChromeDriver() {
        WebDriverManager.chromedriver().setup();
    }


    @BeforeMethod
    public void initChromeDriver() {
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
    }

    @AfterMethod(alwaysRun = true)
    public void closeDriver() {
        driver.quit();
    }



    }

