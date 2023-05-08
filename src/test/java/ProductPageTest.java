import it_academy.links.Links;
import it_academy.pageobject.CatalogPage;
import it_academy.pageobject.Header;
import it_academy.pageobject.ProductPage;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static com.codeborne.selenide.Selenide.open;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ProductPageTest extends BaseTest{
    private final CatalogPage catalogPage = new CatalogPage();
    private final ProductPage productPage = new ProductPage();

    @Test
    public void ProductPageTest(){
        open(Links.HOMEPAGE.getLink());
        new Header().clickOnMainNavigationLink("Каталог");
        catalogPage.clickOnCatalogClassifierButton("Компьютеры")
                .clickOnCatalogClassifierCategoryLink("Комплектующие")
                .clickOnProductLink("Видеокарты");
        int productCount = productPage.countProducts();
        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(productPage.getProductDescriptionList()).hasSize(productCount);
        softly.assertThat(productPage.isProductDescriptionDisplayed()).isTrue();
        softly.assertThat(productPage.getProductRatingList()).hasSize(productCount);
        softly.assertThat(productPage.isProductRatingDisplayed()).isTrue();
        softly.assertThat(productPage.getProductImageList()).hasSize(productCount);
        softly.assertThat(productPage.isProductImageDisplayed()).isTrue();
        softly.assertThat(productPage.getProductNameList()).hasSize(productCount);
        softly.assertThat(productPage.isProductNameDisplayed()).isTrue();
        softly.assertThat(productPage.getProductPriceList()).hasSize(productCount);
        softly.assertThat(productPage.isProductPriceDisplayed()).isTrue();
        softly.assertThat(productPage.getProductCheckBoxList()).hasSize(productCount);
        softly.assertThat(productPage.isProductCheckBoxDisplayed()).isTrue();
        softly.assertAll();
    }
}
