package it_academy.pageobject;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;

public class SearchFieldFrame extends BasePage {

    private final SelenideElement searchResults = $x("//ul[@class = 'search__results']");
    private final SelenideElement searchField = $x("//input[contains(@class, 'search')]");
    private final ElementsCollection itemCategories = $$x("//div[contains(@class, 'item_category')]");
    private final ElementsCollection searchTabItems = $$x("//div[contains(@class, 'search__tabs-item')]");
    private final SelenideElement productImage = $x("//img");
    private final SelenideElement offerButton = $x("//a[contains(@class, 'button_orange')]");
    private final ElementsCollection offerButtons = $$x("//a[contains(@class, 'button_orange')]");
    private final ElementsCollection itemProducts = $$x("//div[@class = 'result__item result__item_product']");
    private final ElementsCollection searchResultTitles = $$x("//div[@class = 'product__title']/a");

    public ElementsCollection getSearchResultsTitles(String text) {
        return searchResultTitles;
    }

    public ElementsCollection getItemProducts() {
        return itemProducts;
    }

    public CatalogPage clickOnOfferButton() {
        offerButton.shouldBe(Condition.visible).click();
        return new CatalogPage();
    }

    public ElementsCollection getOfferButtons() {
        return offerButtons;
    }

    public CatalogPage clickOnProductImage() {
        productImage.shouldBe(Condition.visible).click();
        return new CatalogPage();
    }

    public SearchCatalogDropList switchBackToCatalogDropList() {
        switchTo().defaultContent();
        return new SearchCatalogDropList();
    }

    public SelenideElement getSearchResults() {
        return searchResults;
    }

    public ElementsCollection getSearchTabItems() {
        return searchTabItems;
    }

    public ElementsCollection getItemCategories() {
        return itemCategories;
    }

    public SearchFieldFrame clearSearchField() {
        searchField.clear();
        return this;
    }
}
