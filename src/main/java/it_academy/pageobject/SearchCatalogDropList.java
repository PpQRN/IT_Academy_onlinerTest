package it_academy.pageobject;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.switchTo;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class SearchCatalogDropList extends BasePage {
    private final By searchDroplist = By.xpath("//div[contains(@class, 'modal-dialog')]");
    private final By searchField = By.xpath("//input[contains(@class, 'search')]");
    private final By searchFieldFrame = By.xpath("//iframe[@class = 'modal-iframe']");

    public SearchCatalogDropList clickOnSearchField() {
        $(searchDroplist).click();
        return new SearchCatalogDropList();
    }

    public SearchCatalogDropList enterText(String text) {
        $(searchField).sendKeys(text);
        getWebDriver().manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        return this;
    }

    public SelenideElement getDropField() {
        return $(searchDroplist);
    }

    public SearchFieldFrame switchToSearchFieldFrame() {
        switchTo().frame($(searchFieldFrame));
        return new SearchFieldFrame();
    }

}
