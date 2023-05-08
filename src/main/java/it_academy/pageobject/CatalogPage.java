package it_academy.pageobject;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;

import java.util.List;
import java.util.stream.Collectors;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;
import static java.lang.String.format;

public class CatalogPage extends BasePage {

    private final ElementsCollection catalogPages = $$x("//li[@class = " +
            "'catalog-navigation-classifier__item ']//span[contains(@class, 'wrapper')]");
    private final ElementsCollection catalogNavigationAsideListTitle = $$x("//div[contains(@class, " +
            "'catalog-navigation-list__aside_active')] " +
            "/div /div /div[@class = 'catalog-navigation-list__aside-title']");

    private final ElementsCollection droplistTitle = $$x("//div[contains(@class, 'aside-item_active')]" +
            "//div[contains(@class, 'dropdown-list')]" +
            "/a[contains(@href, 'onliner')]" +
            "//span[contains(@class, 'title')]");

    private final ElementsCollection dropListDescription = $$x("//div[contains(@class, 'aside-item_active')]" +
            "//div[contains(@class, 'dropdown-list')]/a[contains(@href, 'onliner')]//span[contains(@class, 'description')]");

    private final ElementsCollection DROPLISTElements = $$x("//div[contains(@class, 'aside-item_active')]" +
            "//div[contains(@class, 'dropdown-list')]/a[contains(@href, 'onliner')]");

    private final ElementsCollection catalogNavigationAsidelist = $$x("//div[contains(@class, " +
            "'catalog-navigation-list__aside_active')] /div /div");

    private final ElementsCollection catalogNavigationClassifierItems = $$x("//li[@class = " +
            "'catalog-navigation-classifier__item ']");

    private static final String CATALOG_CLASSIFIER_LINK_XPATH_PATTERN =
            "//span[contains(@class, 'wrapper') and contains(text(), '%s')]";

    private static final String CATALOG_CLASSIFIER__CATEGORY_LINK_XPATH_PATTERN =
            "//div[contains(@class, 'aside-list')]//div[contains(@class, 'aside-title') and contains(text(), '%s')]";

    private static final String PRODUCT_XPATH_PATTERN =
            "//div[contains(@class, 'aside-item_active')]//div[contains(@class, 'dropdown-list')]"
                    + "/a[contains(@href, 'onliner')]//span[contains(@class, 'title') and contains(text(), '%s')]";

    public CatalogPage clickOnCatalogClassifierLink(String link) {
        $x(format(CATALOG_CLASSIFIER_LINK_XPATH_PATTERN, link))
                .shouldBe(Condition.visible)
                .click();
        return this;
    }

    public CatalogPage clickOnCatalogClassifierCategoryLink(String link) {
        $x(format(CATALOG_CLASSIFIER__CATEGORY_LINK_XPATH_PATTERN, link))
                .shouldBe(Condition.visible)
                .click();
        return this;
    }

    public CatalogPage clickOnCatalogClassifierButton(String button) {
        $x(String.format(CATALOG_CLASSIFIER_LINK_XPATH_PATTERN, button))
                .shouldBe(Condition.visible)
                .click();
        return this;
    }

    public ProductPage clickOnProductLink(String product) {
        $x(format(PRODUCT_XPATH_PATTERN, product))
                .shouldBe(Condition.visible)
                .click();
        return new ProductPage();
    }

    public List<String> getCatalogListText() {
        List<String> elements = catalogPages.texts();
        return elements.stream()
                .filter(element -> !element.equals("Onlíner Prime"))
                .collect(Collectors.toList());
    }

    public ElementsCollection getCatalogList() {
        return catalogPages;
    }

    public ElementsCollection getCatalogNavigationAsideListTitles() {
        return catalogNavigationAsideListTitle;
    }

    public ElementsCollection getCatalogNavigationAsideList() {
        return catalogNavigationAsidelist;
    }

    public ElementsCollection getDropListElements() {
        return DROPLISTElements;
    }

    public ElementsCollection getCatalogNavigationClassifierButtons() {
        return catalogNavigationClassifierItems;
    }

    public ElementsCollection getDropListTitle() {
        return droplistTitle;
    }

    public ElementsCollection getDropListDescription() {
        return dropListDescription;
    }
}