package it_academy.pageobject;

import com.codeborne.selenide.SelenideElement;
import it_academy.framework.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.function.Supplier;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static java.time.Duration.ofSeconds;
import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

public abstract class BasePage {

    public BasePage() {
        DriverManager.initDriver("chrome");
    }

    public WebElement waitForElementVisible(By by) {
        Wait<WebDriver> wait = new WebDriverWait(getWebDriver(), ofSeconds(30));
        return wait.until(visibilityOfElementLocated(by));
    }

    public WebElement waitForElementToBeClickable(By by) {
        Wait<WebDriver> wait = new WebDriverWait(getWebDriver(), ofSeconds(30));
        return wait.until(elementToBeClickable(by));
    }

    public void navigate(String url) {
        getWebDriver().get(url);
    }

    public String getBrowserTitle() {
        return getWebDriver().getTitle();
    }

    public void fillInFieldWithValue(WebElement field, String value) {
        field.clear();
        field.sendKeys(value);
    }

    public void performValidationInLastOpenedWindowTabAndCloseItAfter(Supplier action) {
        String currentWindowHandle = getWebDriver().getWindowHandle();
        switchToLastOpenedWindow(currentWindowHandle);
        try {
            action.get();
        } finally {
            getWebDriver().close();
            getWebDriver().switchTo().window(currentWindowHandle);
        }
    }

    public void switchToLastOpenedWindow(String currentWindowHandle) {
        String lastWindowHandle = getWebDriver().getWindowHandles()
                .stream()
                .filter(handle -> !handle.equals(currentWindowHandle))
                .reduce((first, second) -> second)
                .orElseThrow(() -> new RuntimeException("No window handle found"));
        getWebDriver().switchTo().window(lastWindowHandle);
    }

    public String getCurrentURL(){
        return getWebDriver().getCurrentUrl();
    }

}