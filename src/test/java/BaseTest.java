import it_academy.framework.DriverManager;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;

public class BaseTest {
    protected WebDriver driver;

    @BeforeEach
    public void setup() {
        DriverManager.initDriver("chrome");
    }

    public String getCurrentUrl(){return driver.getCurrentUrl();}
}