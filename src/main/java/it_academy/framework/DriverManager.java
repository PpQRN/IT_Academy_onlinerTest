package it_academy.framework;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;

import static com.codeborne.selenide.Selenide.open;


public class DriverManager {

    public static void initDriver(String driverType){
        Configuration.browser = driverType;
        Configuration.pageLoadTimeout = 20000;
        open();
        WebDriverRunner.getWebDriver().manage().window().maximize();
    }
}