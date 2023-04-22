import it_academy.links.LinksEnum;
import it_academy.pageobject.*;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


public class CatalogTestNew extends BaseTest {
    private CatalogPage catalogPage = new CatalogPage();
    private ProductPage productPage = new ProductPage();
    private List<String> catalogList = Arrays.asList("Электроника", "Компьютеры и сети",
            "Бытовая техника", "На каждый день", "Стройка и ремонт",
            "Дом и сад", "Авто и мото", "Красота и спорт", "Детям и мамам");


//    @Test
//    public void CatalogSectionsTest() {
//        goToPage(LinksEnum.homepage);
//        new Header().clickOnMainNavigationLink("Каталог");
//        assertThat(catalogPage.getCatalogListText()).hasSize(9).containsAll(catalogList);
//    }
//
//    @Test
//    public void CatalogDropListTest() {
//        goToPage(LinksEnum.homepage);
//        new Header().clickOnMainNavigationLink("Каталог");
//        //Дальше поменяй Xpath чубрик
//        catalogPage.clickOnCatalogClassifierButton("Компьютеры");
//        assertThat(catalogPage.getCatalogNavigationAsideList())
//                .hasSize(catalogPage.countCatalogNavigationAsideList());
//        assertThat(catalogPage.isAsideListTitleDisplayed())
//                .isEqualTo(true);
//    }
//
//    @Test
//    public void CatalogDropListContentTest() {
//        goToPage(LinksEnum.homepage);
//        new Header().clickOnMainNavigationLink("Каталог");
//        catalogPage.clickOnCatalogClassifierButton("Компьютеры")
//                .clickOnCatalogClassifierCategoryLink("Комплектующие");
//        assertThat(catalogPage.getDropListTitle()).hasSize(catalogPage.countDroplistElements());
//        assertThat(catalogPage.isDroplistTitleDisplayed()).isTrue();
//        assertThat(catalogPage.getDropListDescription()).hasSize(catalogPage.countDroplistElements()*2);
//        assertThat(catalogPage.isDroplistDescriptionDisplayed()).isTrue();
//    }

    @Test
    public void ProductPageTest(){
        goToPage(LinksEnum.homepage);
        new Header().clickOnMainNavigationLink("Каталог");
        catalogPage.clickOnCatalogClassifierButton("Компьютеры")
                .clickOnCatalogClassifierCategoryLink("Комплектующие")
                .clickOnProductLink("Видеокарты");
        assertThat(productPage.getProductDescriptionList()).hasSize(productPage.countProducts());
        assertThat(productPage.getProductRatingList()).hasSize(productPage.countProducts());
        assertThat(productPage.getProductImageList()).hasSize(productPage.countProducts());
        assertThat(productPage.getProductNameList()).hasSize(productPage.countProducts());
        assertThat(productPage.getProductPriceList()).hasSize(productPage.countProducts());
        assertThat(productPage.getProductCheckBoxList()).hasSize(productPage.countProducts());

    }
}
