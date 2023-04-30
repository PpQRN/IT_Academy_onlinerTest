package it_academy.pageobject;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class SearchCatalogDropList extends BasePage {
    private final By searchDroplist = By.xpath("//div[contains(@class, 'modal-dialog')]");
    private final By searchNewField = By.xpath("//input[contains(@class, 'search')]");

    public SearchCatalogDropList clickOnSearchField(){
        $(searchDroplist).click();
        return new SearchCatalogDropList();
    }

    public void sendTextInSearchField(String text){
        $(searchDroplist).sendKeys(text);
    }

    public SearchCatalogDropList enterText(String text){
        $(searchNewField).sendKeys(text);
        return this;
    }

    public SelenideElement getDropField(){
        return $(searchDroplist);
    }
}
