import it_academy.links.Links;
import it_academy.pageobject.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class CatalogTest extends BaseTest {
    private final CatalogPage catalogPage = new CatalogPage();
    private final ProductPage productPage = new ProductPage();
    private final List<String> catalogList = Arrays.asList("Электроника", "Компьютеры и сети",
            "Бытовая техника", "На каждый день", "Стройка и ремонт",
            "Дом и сад", "Авто и мото", "Красота и спорт", "Детям и мамам");

    @BeforeEach
    public void goToMainPage(){
        goToPage(Links.homepage);
    }

    @Test
    public void CatalogSectionsTest() {
        new Header().clickOnMainNavigationLink("Каталог");
        assertThat(catalogPage.getCatalogListText()).hasSize(catalogPage.countCatalogNavigationClassifierButtons()-1).containsAll(catalogList);
    }

    @Test
    public void CatalogDropListTest() {
        new Header().clickOnMainNavigationLink("Каталог");
        catalogPage.clickOnCatalogClassifierButton("Компьютеры")
                .clickOnCatalogClassifierCategoryLink("Комплектующие");
        assertThat(catalogPage.getCatalogNavigationAsideList())
                .hasSize(catalogPage.countCatalogNavigationAsideList());
        assertThat(catalogPage.isAsideListTitleDisplayed())
                .isEqualTo(true);
    }

    @Test
    public void CatalogDropListContentTest() {
        new Header().clickOnMainNavigationLink("Каталог");
        catalogPage.clickOnCatalogClassifierButton("Компьютеры")
                .clickOnCatalogClassifierCategoryLink("Комплектующие");
        assertThat(catalogPage.getDropListTitle()).hasSize(catalogPage.countDroplistElements());
        assertThat(catalogPage.isDroplistTitleDisplayed()).isTrue();
        assertThat(catalogPage.getDropListDescription()).hasSize(catalogPage.countDroplistElements()*2);
        assertThat(catalogPage.isDroplistDescriptionDisplayed()).isTrue();
    }
}
