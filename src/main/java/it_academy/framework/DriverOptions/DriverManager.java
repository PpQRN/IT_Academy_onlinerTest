package it_academy.framework.DriverOptions;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.remote.RemoteWebDriver;

import static com.codeborne.selenide.Selenide.open;


public class DriverManager {
    private static ThreadLocal<RemoteWebDriver> driver = new ThreadLocal<>();

    public static void initDriver(String driverType) {
        if (driver.get() == null) {
            if (driverType.equals("remote")) {
                new RemoteDriverCreator().create();
            } else {
                Configuration.browser = driverType;
                Configuration.pageLoadTimeout = 20000;
                open();
                WebDriverRunner.getWebDriver().manage().window().maximize();
            }
        }
    }
}
