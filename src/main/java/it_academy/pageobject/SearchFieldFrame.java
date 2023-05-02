package it_academy.pageobject;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.impl.CollectionElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.Wait;

import java.util.TreeMap;

import static com.codeborne.selenide.Selenide.*;

public class SearchFieldFrame extends BasePage{

    private final By searchResults = By.xpath("//ul[@class = 'search__results']");
    private final By searchField = By.xpath("//input[contains(@class, 'search')]");
    private final By itemCategories = By.xpath("//div[contains(@class, 'item_category')]");
    private final By searchTabItems = By.xpath("//div[contains(@class, 'search__tabs-item')]");
    private final By productImage = By.xpath("//img");
    private final By offerButton = By.xpath("//a[contains(@class, 'button_orange')]");
    private final By itemProducts = By.xpath("//div[@class = 'result__item result__item_product']");

    public ElementsCollection getItemProducts(){
        return $$(itemProducts);
    }

    public CatalogPage clickOnOfferButton(){
        $(offerButton).click();
        return new CatalogPage();
    }

    public ElementsCollection getOfferButtons(){
        return $$(offerButton);
    }

    public CatalogPage clickOnProductImage(){
        $(productImage).click();
        return new CatalogPage();
    }

    public SearchCatalogDropList switchBackToCatalogDropList(){
        switchTo().defaultContent();
        return new SearchCatalogDropList();
    }

    public SelenideElement getSearchResults() {
        return $(searchResults);
    }

    public ElementsCollection getSearchTabItems(){
        return $$(searchTabItems);
    }

    public ElementsCollection getItemCategories(){
        return $$(itemCategories);
    }

    public SearchFieldFrame clearSearchField() {
        $(searchField).clear();
        return this;
    }
}
