import it_academy.links.Links;
import it_academy.pageobject.CatalogPage;
import it_academy.pageobject.Header;
import it_academy.pageobject.ProductPage;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.assertj.core.api.Assertions.assertThat;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ProductPageTest extends BaseTest{
    private final CatalogPage catalogPage = new CatalogPage();
    private final ProductPage productPage = new ProductPage();

    @Test
    public void ProductPageTest(){
        goToPage(Links.homepage);
        new Header().clickOnMainNavigationLink("Каталог");
        catalogPage.clickOnCatalogClassifierButton("Компьютеры")
                .clickOnCatalogClassifierCategoryLink("Комплектующие")
                .clickOnProductLink("Видеокарты");
        int productCount = productPage.countProducts();
        assertThat(productPage.getProductDescriptionList()).hasSize(productCount);
        assertThat(productPage.isProductDescriptionDisplayed()).isTrue();
        assertThat(productPage.getProductRatingList()).hasSize(productCount);
        assertThat(productPage.isProductRatingDisplayed()).isTrue();
        assertThat(productPage.getProductImageList()).hasSize(productCount);
        assertThat(productPage.isProductImageDisplayed()).isTrue();
        assertThat(productPage.getProductNameList()).hasSize(productCount);
        assertThat(productPage.isProductNameDisplayed()).isTrue();
        assertThat(productPage.getProductPriceList()).hasSize(productCount);
        assertThat(productPage.isProductPriceDisplayed()).isTrue();
        assertThat(productPage.getProductCheckBoxList()).hasSize(productCount);
        assertThat(productPage.isProductCheckBoxDisplayed()).isTrue();
    }
}
