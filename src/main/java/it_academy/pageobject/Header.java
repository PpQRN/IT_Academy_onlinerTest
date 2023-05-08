package it_academy.pageobject;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static java.lang.String.format;

public class Header extends BasePage {

    private static final String MAIN_NAVIGATION_LINK_XPATH_PATTER =
            "//*[contains(@class, 'main-navigation__text') and contains(text(), '%s')]";

    private final By searchField = By.xpath("//input[contains(@class, 'fast-search')]");

    private final SelenideElement innerSearchText = $x("//input[contains(@class, 'fast')]");

    public CatalogPage clickOnMainNavigationLink(String link) {
        $(By.xpath(format(MAIN_NAVIGATION_LINK_XPATH_PATTER, link)))
                .shouldBe(Condition.visible)
                .click();
        return new CatalogPage();
    }

    public SelenideElement getInnerSearchText() {return innerSearchText;}

    public SearchCatalogDropList clickOnSearchField(){
        $(searchField)
                .shouldBe(Condition.visible)
                .click();
        return new SearchCatalogDropList();
    }
}