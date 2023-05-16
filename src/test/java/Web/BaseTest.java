package Web;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import it_academy.framework.DriverManager;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;

public class BaseTest {
    protected WebDriver driver;

//    @BeforeEach
//    public void setup() {
//        DriverManager.initDriver("chrome");
//    }

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