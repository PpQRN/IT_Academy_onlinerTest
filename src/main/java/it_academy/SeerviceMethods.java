package it_academy;

import it_academy.framework.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SeerviceMethods {
    WebDriver driver = DriverManager.getWebDriver();

    public SeerviceMethods() {
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
