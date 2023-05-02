package it_academy.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.stream.Collectors;

import static java.lang.String.format;

public class CatalogPage extends BasePage {

    private static final By catalogPages = By.xpath("//li[@class = " +
            "'catalog-navigation-classifier__item ']//span[contains(@class, 'wrapper')]");
    private static final By catalogNavigationAsideListTitle = By.xpath("//div[contains(@class, " +
            "'catalog-navigation-list__aside_active')] " +
            "/div /div /div[@class = 'catalog-navigation-list__aside-title']");

    private static final By droplistTitle = By.xpath("//div[contains(@class, 'aside-item_active')]" +
            "//div[contains(@class, 'dropdown-list')]" +
            "/a[contains(@href, 'onliner')]" +
            "//span[contains(@class, 'title')]");

    private final By dropListDescription = By.xpath("//div[contains(@class, 'aside-item_active')]" +
            "//div[contains(@class, 'dropdown-list')]/a[contains(@href, 'onliner')]" +
            "//span[contains(@class, 'description')]/descendant-or-self::*");

    private final By DROPLISTElements = By.xpath("//div[contains(@class, 'aside-item_active')]" +
            "//div[contains(@class, 'dropdown-list')]/a[contains(@href, 'onliner')]");

    private final By catalogNavigationAsidelist = By.xpath("//div[contains(@class, " +
            "'catalog-navigation-list__aside_active')] /div /div");

    private final By catalogNavigationClassifierItems = By.xpath("//li[@class = 'catalog-navigation-classifier__item ']");

    private static final String CATALOG_CLASSIFIER_LINK_XPATH_PATTERN =
            "//span[contains(@class, 'wrapper') and contains(text(), '%s')]";

    private static final String CATALOG_CLASSIFIER__CATEGORY_LINK_XPATH_PATTERN =
            "//div[contains(@class, 'aside-list')]//div[contains(@class, 'aside-title') and contains(text(), '%s')]";

    private static final String PRODUCT_XPATH_PATTERN =
            "//div[contains(@class, 'aside-item_active')]//div[contains(@class, 'dropdown-list')]"
                    + "/a[contains(@href, 'onliner')]//span[contains(@class, 'title') and contains(text(), '%s')]";

    public CatalogPage clickOnCatalogClassifierLink(String link) {
        waitForElementVisible(By.xpath(format(CATALOG_CLASSIFIER_LINK_XPATH_PATTERN, link)))
                .click();
        return this;
    }

    public CatalogPage clickOnCatalogClassifierCategoryLink(String link) {
        waitForElementVisible(By.xpath(format(CATALOG_CLASSIFIER__CATEGORY_LINK_XPATH_PATTERN, link)))
                .click();
        return this;
    }

    public CatalogPage clickOnCatalogClassifierButton(String button) {
        waitForElementVisible(By.xpath(String.format(CATALOG_CLASSIFIER_LINK_XPATH_PATTERN, button)))
                .click();
        return this;
    }

    public ProductPage clickOnProductLink(String product) {
        waitForElementVisible(By.xpath(format(PRODUCT_XPATH_PATTERN, product)))
                .click();
        return new ProductPage();
    }

    public List<String> getCatalogListText() {
        List<WebElement> elements = selectElements(catalogPages);
        return elements.stream()
                .map(WebElement::getText)
                .filter(element -> !element.equals("Onlíner Prime"))
                .collect(Collectors.toList());
    }

    public List<WebElement> getCatalogNavigationAsideList() {
        return selectElements(catalogNavigationAsideListTitle);
    }

    public int countCatalogNavigationAsideList() {
        return selectElements(catalogNavigationAsidelist).size();
    }

    public boolean isAsideListTitleDisplayed() {
        return isElementDisplayed(catalogNavigationAsidelist);
    }

    public boolean isDroplistTitleDisplayed() {
        return isElementDisplayed(droplistTitle);
    }

    public boolean isDroplistDescriptionDisplayed() {
        return isElementDisplayed(droplistTitle);
    }

    public int countDroplistElements() {
        return selectElements(DROPLISTElements).size();
    }

    public int countCatalogNavigationClassifierButtons(){
        return selectElements(catalogNavigationClassifierItems).size();
    }

    public List<WebElement> getDropListTitle() {
        return selectElements(droplistTitle);
    }

    public List<WebElement> getDropListDescription() {
        return selectElements(dropListDescription);
    }
}