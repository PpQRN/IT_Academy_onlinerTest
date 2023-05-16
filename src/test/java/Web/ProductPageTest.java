package Web;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import it_academy.links.Links;
import it_academy.pageobject.Header;
import it_academy.pageobject.ProductPage;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.List;

import static com.codeborne.selenide.Selenide.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ProductPageTest extends BaseTest {
    private final ProductPage productPage = new ProductPage();

    @Test
    public void ProductPageTest() {
        open(Links.HOMEPAGE.getLink());
        new Header().clickOnMainNavigationLink("Каталог")
                .clickOnCatalogClassifierButton("Компьютеры")
                .clickOnCatalogClassifierCategoryLink("Комплектующие")
                .clickOnProductLink("Видеокарты");
        int productCount = productPage.getAllProducts().size();
        assertElementsExist(productPage.getProductDescriptionList(), productCount);
        assertElementsExist(productPage.getProductRatingList(), productCount);
        assertElementsExist(productPage.getProductImageList(), productCount);
        assertElementsExist(productPage.getProductNameList(), productCount);
        assertElementsExist(productPage.getProductPriceList(), productCount);
        assertElementsExist(productPage.getProductCheckBoxList(), productCount);
    }

    private static void assertElementsExist(ElementsCollection collection, int size){
        collection.shouldHave(CollectionCondition.size(size));
        ((List<SelenideElement>) collection).forEach(element -> element.shouldBe(Condition.visible));
    }
}
