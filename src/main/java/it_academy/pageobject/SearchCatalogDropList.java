package it_academy.pageobject;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;

public class SearchCatalogDropList extends BasePage {
    private final SelenideElement searchDroplist = $x("//div[contains(@class, 'modal-dialog')]");
    private final SelenideElement searchField = $x("//input[contains(@class, 'search')]");
    private final SelenideElement searchFieldFrame = $x("//iframe[@class = 'modal-iframe']");

    public SearchCatalogDropList clickOnSearchField() {
        searchDroplist
                .shouldBe(Condition.visible)
                .click();
        return new SearchCatalogDropList();
    }

    public SearchCatalogDropList enterText(String text) {
        try {
            searchField
                    .shouldBe(Condition.visible)
                    .sendKeys(text);
                Thread.sleep(1000);
        } catch (InterruptedException exception) {
            System.out.println("что-то прервало ожидание");
        }
        return this;
    }

    public SelenideElement getDropField() {
        return searchDroplist;
    }

    public SearchFieldFrame switchToSearchFieldFrame() {
        switchTo().frame(searchFieldFrame);
        return new SearchFieldFrame();
    }

}
