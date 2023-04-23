import it_academy.framework.DriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;


public class BaseTest {
    protected WebDriver driver;

    @BeforeEach
    public void setup() {
        driver = DriverManager.getWebDriver();
        driver.manage().window().maximize();
    }

    @AfterAll
    public void tearDown() {
        DriverManager.closeBrowser();
    }

    public void goToPage(String url) {
        driver.get(url);
    }
}