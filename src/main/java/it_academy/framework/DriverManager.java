package it_academy.framework;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.util.concurrent.TimeUnit;

import static com.codeborne.selenide.Selenide.open;


public class DriverManager {

    private static ThreadLocal<RemoteWebDriver> driver =
            new ThreadLocal();

    private static void setWebDriver(RemoteWebDriver webDriver) {
        driver.set(webDriver);
        driver.get().manage().window().maximize();
        driver.get().manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get().manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
    }

    public static void startBrowser() {
        setWebDriver(Driver.getByDriverType(System.getProperty("driverType", "chrome"))
                .getWebDriverCreator()
                .create());
    }

    public static WebDriver getWebDriver() {
        if (driver.get() == null) {
            startBrowser();
        }
        return driver.get();
    }

    public static void closeBrowser() {
        driver.get().close();
        driver.remove();
    }

    public static void initDriver(String driverType){
        Configuration.browser = driverType;
        Configuration.pageLoadTimeout = 20000;
        open();
        WebDriverRunner.getWebDriver().manage().window().maximize();
    }
}