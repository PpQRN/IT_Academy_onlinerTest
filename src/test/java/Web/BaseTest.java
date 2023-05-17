package Web;

import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import it_academy.framework.DriverOptions.DriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;

public class BaseTest {
    protected WebDriver driver;
    @BeforeAll
    public static void setup() {
        DriverManager.initDriver(System.getProperty("driverType"));
    }

    @AfterAll
    public static void tearDown(){
        WebDriverRunner.closeWebDriver();
    }

    @BeforeAll
    public static void addListener() {
        SelenideLogger.addListener("AllureSelenide",
                new AllureSelenide()
                        .screenshots(true)
                        .savePageSource(true));
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }
}