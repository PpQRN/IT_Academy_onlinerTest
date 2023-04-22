import it_academy.SeerviceMethods;
import it_academy.links.LinksEnum;
import it_academy.pageobject.CatalogPageMy;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static org.assertj.core.api.Assertions.assertThat;

public class CatalogTest extends BaseTest {
//    private CatalogPageMy catalogPage = new CatalogPageMy();
//
//
//    @Test
//    public void CatalogSectionsTest() {
//        goToPage(LinksEnum.catalog);
//        assertThat(catalogPage.CatalogList()).contains("Электроника", "Компьютеры и сети",
//                "Бытовая техника", "На каждый день", "Стройка и ремонт",
//                "Дом и сад","Авто и мото","Красота и спорт","Детям и мамам");
//    }
//
//    @Test
//    public void CatalogDropListTest() {
//        goToPage(LinksEnum.catalog);
//        catalogPage.clickOnButton("Компьютеры и");
//        SeerviceMethods seerviceMethods = new SeerviceMethods();
//        assertThat(seerviceMethods.isElementDisplayed(By.xpath("//div[contains(@class, " +
//                        "'catalog-navigation-list__aside-list') and contains(., ' Ноутбуки, компьютеры, мониторы  ')]" +
//                        "/child::*/div[contains(@class, 'title')]"))).isEqualTo(true);
//    }
//
//    @Test
//    public void CatalogDropListContentTest() {
//        goToPage(LinksEnum.catalog);
//        catalogPage.clickOnButton("Компьютеры и");
//        catalogPage.moveToElement("Комплектующие");
//        catalogPage.checkIfElementsExist(CatalogPageMy.DROPLIST_TITLE_XPATH);
//        assertThat(catalogPage.checkIfElementsExist(CatalogPageMy.DROPLIST_TITLE_XPATH)).isTrue();
//        assertThat(catalogPage.checkIfElementsExist(CatalogPageMy.DROPLIST_DESCRIPTION_XPATH)).isTrue();
//    }
//

}

