import it_academy.framework.DriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;


public class BaseTest {
    protected WebDriver driver;
            //= DriverManager.getWebDriver();



    @BeforeEach
    public void setup(){
        driver = DriverManager.getWebDriver();
        driver.manage().window().maximize();
    }

//    @AfterEach
//    public void closeBroser(){
//        DriverManager.closeBrowser();
//    }

//    @BeforeSuite
//    public void setup() {
//        driver = DriverManager.getWebDriver();
//        driver.manage().window().maximize();
//    }

    public void goToPage(String url) {
        driver.get(url);
    }
}