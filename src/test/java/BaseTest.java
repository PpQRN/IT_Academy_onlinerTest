import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import it_academy.framework.DriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;

import java.time.Duration;


public class BaseTest {
    protected WebDriver driver;

    @BeforeEach
    public void setup() {
        DriverManager.initDriver("chrome");
//        driver = DriverManager.getWebDriver();
//        driver.manage().window().maximize();
    }

//    @AfterAll
//    public void tearDown() {
//        DriverManager.closeBrowser();
//    }

    public void goToPage(String url) {
        Selenide.open(url);
    }

    public String getTextFromWebElemets(SelenideElement element){
        return element.getText();
    }

    public String getCurrentUrl(){return driver.getCurrentUrl();}
}