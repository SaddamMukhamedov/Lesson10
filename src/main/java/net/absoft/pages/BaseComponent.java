package net.absoft.pages;

import org.openqa.selenium.WebDriver;


public class BaseComponent {
    protected WebDriver driver;

    public BaseComponent(WebDriver driver) {
        this.driver = driver;
    }
}
