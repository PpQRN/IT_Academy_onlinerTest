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

    //Я помню, что нельзя использовать sleep, но из-за специфики поля поиска тесты, в которых результатов поиска не должно быть
    //будут проходить при любом вводе, так как изначально результаты пустые и им нужно время для прогрузки
    //вариантов поумнее я к сожалению не придумал, ибо там особо нет элементов которых можно было подождат
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
