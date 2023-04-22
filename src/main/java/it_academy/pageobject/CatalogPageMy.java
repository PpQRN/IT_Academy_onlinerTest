package it_academy.pageobject;

import it_academy.SeerviceMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;


import java.util.List;
import java.util.stream.Collectors;

public class CatalogPageMy extends BasePage {
//    private static final String CATALOG_BUTTON_XPATH_PATTERN = "//span[contains(@class, 'wrapper') and contains(text(), '%s')]";
//    private static final String CATALOG_DROPLIST_BUTTON_XPATH_PATTERN = "//div[contains(@class, " +
//            "'catalog-navigation-list__aside-list') and contains(., ' Ноутбуки, компьютеры, мониторы  ')]" +
//            "/child::*/div[contains(text(), '%s')]";
//    public static final String DROPLIST_TITLE_XPATH = "//div[contains(@class, 'aside-item_active')]" +
//            "//div[contains(@class, 'dropdown-list')]" +
//            "/a[contains(@href, 'onliner')]" +
//            "//span[contains(@class, 'title')]";
//    public static final String DROPLIST_DESCRIPTION_XPATH = "//div[contains(@class, 'aside-item_active')]" +
//            "//div[contains(@class, 'dropdown-list')]/a[contains(@href, 'onliner')]" +
//            "//span[contains(@class, 'description')]/descendant-or-self::*";
//
//    //   Ссылка название //a[contains(@class, 'js-product-title-link')]
//    //   Описание товаров //span[contains(@data-bind, 'product.description')]
//    //   рейтинги товаров  //div[contains(@class, 'part_4')]//div[contains(@class, 'rating-group')]//a[contains(@class, 'schema-product')]
//    //   цена товаров  //div[contains(@class, 'product__price')]/a[contains(@class, 'js-product-price-link') and contains(@href, 'prices')]
//    //   иконка товара //a[contains(@class, 'image-link')]/img
//    //   чекбокс  //span[contains(@class, 'i-checkbox i-checkbox_yellow')]
//
//    public List<String> CatalogList(){
//         List<WebElement> elements = SelectElements(By.xpath("//li[@class = " +
//                "'catalog-navigation-classifier__item ']//span[contains(@class, 'wrapper')]"));
//        return elements.stream()
//                .map(WebElement::getText)
//                .collect(Collectors.toList());
//    }
//
//    public List<String> CatalogComputerDropList(){
//        List<WebElement> elements = SelectElements(By.xpath("//div[contains(@class, " +
//                "'catalog-navigation-list__aside-list') and contains(., ' Ноутбуки, компьютеры, мониторы  ')]" +
//                "/child::*/div[contains(@class, 'title')]"));
//        return elements.stream()
//                .map(WebElement::getText)
//                .collect(Collectors.toList());
//    }
//
//    public CatalogPageMy clickOnButton(String button) {
//        waitForElementVisible(By.xpath(String.format(CATALOG_BUTTON_XPATH_PATTERN, button)))
//                .click();
//        return this;
//    }
//
//    public CatalogPageMy moveToElement(String element){
//        Actions actions = new Actions(getDriver());
//        waitForElementVisible(By.xpath(String.format(CATALOG_DROPLIST_BUTTON_XPATH_PATTERN, element)));
//        actions.moveToElement(selectElement(By.xpath(String.format(CATALOG_DROPLIST_BUTTON_XPATH_PATTERN, element)))).perform();
//        return this;
//    }
//
//    public boolean checkIfElementsExist(String link){
//        return new SeerviceMethods().isElementDisplayed(By.xpath(link));
//    }
}
