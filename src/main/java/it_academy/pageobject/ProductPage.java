package it_academy.pageobject;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static com.codeborne.selenide.Selenide.$$x;
import static java.lang.String.format;

public class ProductPage extends BasePage {
    private static final ElementsCollection productName = $$x("//a[contains(@class, 'js-product-title-link')]");
    private static final ElementsCollection productDescription = $$x("//span[contains(@data-bind, 'product.description')]");
    private static final ElementsCollection productRating = $$x("//div[contains(@class, 'part_4')]//div[contains(@class, 'rating-group')]//a[contains(@class, 'schema-product')]");
    private static final ElementsCollection productPrice = $$x("//div[contains(@class, 'product__price')]/a[contains(@class, 'js-product-price-link') and contains(@href, 'prices')]");
    private static final ElementsCollection productImage = $$x("//a[contains(@class, 'image-link')]");
    private static final ElementsCollection productCheckBox = $$x("//span[contains(@class, 'i-checkbox i-checkbox_yellow')]");
    private static final ElementsCollection productsAll = $$x("//div[@class = 'schema-product__group']");

    public ProductPage clickOnProductTitle() {
        productName.first().shouldBe(Condition.visible).click();
        return this;
    }
    public ElementsCollection getProductNameList() {
        return productName;
    }
    public ElementsCollection getProductDescriptionList() {
        return productDescription;
    }
    public ElementsCollection getProductRatingList() {
        return productRating;
    }
    public ElementsCollection getProductPriceList() {
        return productPrice;
    }
    public ElementsCollection getProductImageList() {
        return productImage;
    }
    public ElementsCollection getProductCheckBoxList() {
        return productCheckBox;
    }
    public ElementsCollection getAllProducts() {
        return productsAll;
    }
}