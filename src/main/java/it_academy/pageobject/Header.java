package it_academy.pageobject;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static java.lang.String.format;

public class Header extends BasePage {

    private static final String MAIN_NAVIGATION_LINK_XPATH_PATTER =
            "//*[contains(@class, 'main-navigation__text') and contains(text(), '%s')]";

    private final By searchField = By.xpath("//input[contains(@class, 'fast-search')]");

    private final By onlinerLogo = By.xpath("//*[contains(@class, 'onliner_logo')]");

    private final By innerSearchText = By.xpath("//input[contains(@class, 'fast')]");

    public CatalogPage clickOnMainNavigationLink(String link) {
        $(By.xpath(format(MAIN_NAVIGATION_LINK_XPATH_PATTER, link))).click();
        return new CatalogPage();
    }

//    public WebElement getOnlinerLogo() {
//        return waitForElementVisible(onlinerLogo);
//    }
    public SelenideElement getOnlinerLogo(){return $(onlinerLogo);}

    public SelenideElement getInnerSearchText() {return $(innerSearchText);}

    public SearchCatalogDropList clickOnSearchField(){
        $(searchField).click();
        return new SearchCatalogDropList();
    }

    public void enterTextInSearchFild(String text){
        $(searchField).setValue(text);
    }

}