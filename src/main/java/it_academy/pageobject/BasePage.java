package it_academy.pageobject;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public abstract class BasePage {

//    public BasePage() {
//        DriverManager.initDriver(System.getProperty("driverType"));
//    }

    public String getCurrentURL() {
        return getWebDriver().getCurrentUrl();
    }

}