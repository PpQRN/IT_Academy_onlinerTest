package it_academy.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static java.lang.String.format;

public class ProductPage extends BasePage {
    private static final By productName = By.xpath("//a[contains(@class, 'js-product-title-link')]");
    private static final By productDescription = By.xpath("//span[contains(@data-bind, 'product.description')]");
    private static final By productRating = By.xpath("//div[contains(@class, 'part_4')]//div[contains(@class, 'rating-group')]//a[contains(@class, 'schema-product')]");
    private static final By productPrice = By.xpath("//div[contains(@class, 'product__price')]/a[contains(@class, 'js-product-price-link') and contains(@href, 'prices')]");
    private static final By productImage = By.xpath("//a[contains(@class, 'image-link')]/img");
    private static final By productCheckBox = By.xpath("//span[contains(@class, 'i-checkbox i-checkbox_yellow')]");
    private static final By productsAll = By.xpath("//div[@class = 'schema-product__group']");

    public List<WebElement> getProductNameList() {
        return selectElements(productName);
    }

    public boolean isProductNameDisplayed() {
        return isElementDisplayed(productName);
    }

    public List<WebElement> getProductDescriptionList() {
        return selectElements(productDescription);
    }

    public boolean isProductDescriptionDisplayed() {
        return isElementDisplayed(productDescription);
    }

    public List<WebElement> getProductRatingList() {
        return selectElements(productRating);
    }

    public boolean isProductRatingDisplayed() {
        return isElementDisplayed(productRating);
    }

    public List<WebElement> getProductPriceList() {
        return selectElements(productPrice);
    }

    public boolean isProductPriceDisplayed() {
        return isElementDisplayed(productPrice);
    }

    public List<WebElement> getProductImageList() {
        return selectElements(productImage);
    }

    public boolean isProductImageDisplayed() {
        return isElementDisplayed(productImage);
    }

    public List<WebElement> getProductCheckBoxList() {
        return selectElements(productCheckBox);
    }

    public boolean isProductCheckBoxDisplayed() {
        return isElementDisplayed(productCheckBox);
    }

    public int countProducts() {
        return selectElements(productsAll).size();
    }
}