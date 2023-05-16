package it_academy.pageobject;

import it_academy.framework.DriverManager;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public abstract class BasePage {

    public BasePage() {
        DriverManager.initDriver(System.getProperty("browser"));
    }

    public String getCurrentURL() {
        return getWebDriver().getCurrentUrl();
    }

}