package it_academy.pageobject;

import it_academy.framework.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.function.Supplier;

import static java.time.Duration.ofSeconds;
import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

public abstract class BasePage {
    private final WebDriver driver;

    public BasePage() {
        driver = DriverManager.getWebDriver();
    }

    public WebElement waitForElementVisible(By by) {
        Wait<WebDriver> wait = new WebDriverWait(driver, ofSeconds(30));
        return wait.until(visibilityOfElementLocated(by));
    }

    public WebElement waitForElementToBeClickable(By by) {
        Wait<WebDriver> wait = new WebDriverWait(driver, ofSeconds(30));
        return wait.until(elementToBeClickable(by));
    }

    public void navigate(String url) {
        driver.get(url);
    }

    public String getBrowserTitle() {
        return driver.getTitle();
    }

    public void fillInFieldWithValue(WebElement field, String value) {
        field.clear();
        field.sendKeys(value);
    }

//    public boolean isElementDisplayed(By locator) {
//        try {
//            WebDriverWait wait = new WebDriverWait(driver, ofSeconds(10));
//            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
//            return element.isDisplayed();
//        } catch (Exception e) {
//            return false;
//        }
//    }

    public void performValidationInLastOpenedWindowTabAndCloseItAfter(Supplier action) {
        String currentWindowHandle = driver.getWindowHandle();
        switchToLastOpenedWindow(currentWindowHandle);
        try {
            action.get();
        } finally {
            driver.close();
            driver.switchTo().window(currentWindowHandle);
        }
    }

    public void switchToLastOpenedWindow(String currentWindowHandle) {
        String lastWindowHandle = driver.getWindowHandles()
                .stream()
                .filter(handle -> !handle.equals(currentWindowHandle))
                .reduce((first, second) -> second)
                .orElseThrow(() -> new RuntimeException("No window handle found"));
        driver.switchTo().window(lastWindowHandle);
    }

    public List<WebElement> selectElements(By by){
        return driver.findElements(by);
    }

    public WebElement selectElement(By by){
        return driver.findElement(by);
    }

    public boolean isElementDisplayed(By by){
        return this.isExists(by) && this.getFirstVisibleElement(by) != null;
    }

    public boolean isExists(By by) {
        return !driver.findElements(by).isEmpty();
    }

    private WebElement getFirstVisibleElement(By locator){
        List<WebElement> elements = driver.findElements(locator);
        for (WebElement webElement : elements){
            try {
                if (webElement.isDisplayed()){
                    return webElement;
                }
            } catch (StaleElementReferenceException e){
                continue;
            }
        }
        return null;
    }

}