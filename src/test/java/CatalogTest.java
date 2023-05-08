import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import it_academy.links.Links;
import it_academy.pageobject.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.Arrays;
import java.util.List;

import static com.codeborne.selenide.Selenide.open;
import static org.assertj.core.api.Assertions.assertThat;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class CatalogTest extends BaseTest {
    private final CatalogPage catalogPage = new CatalogPage();
    private final Header header = new Header();
    private final List<String> catalogList = Arrays.asList("Электроника", "Компьютеры и сети",
            "Бытовая техника", "На каждый день", "Стройка и ремонт",
            "Дом и сад", "Авто и мото", "Красота и спорт", "Детям и мамам");

    @BeforeEach
    public void goToMainPage() {
        open(Links.HOMEPAGE.getLink());
    }

    @Test
    public void CatalogSectionsTest() {
        List<String> catalogListText = header.clickOnMainNavigationLink("Каталог")
                .getCatalogListText();
        assertThat(catalogListText).hasSize(catalogPage.getCatalogNavigationClassifierButtons().size()-1)
                .containsAll(catalogList);
    }

    @Test
    public void CatalogDropListTest() {
        List <SelenideElement> elements = header.clickOnMainNavigationLink("Каталог")
                .clickOnCatalogClassifierButton("Компьютеры")
                .clickOnCatalogClassifierCategoryLink("Комплектующие")
                .getCatalogNavigationAsideList()
                .shouldHave(CollectionCondition.size(catalogPage.getCatalogNavigationAsideList().size()));
        elements.forEach(element -> element.shouldBe(Condition.visible));
    }

    @Test
    public void CatalogDropListContentTest() {
        header.clickOnMainNavigationLink("Каталог")
                .clickOnCatalogClassifierButton("Компьютеры")
                .clickOnCatalogClassifierCategoryLink("Кассовые");
        List <SelenideElement> dropListTitles = catalogPage.getDropListTitle()
                .shouldHave(CollectionCondition.size(catalogPage.getDropListElements().size()));
        dropListTitles.forEach(element -> element.shouldBe(Condition.visible));
        List <SelenideElement> dropListDescription = catalogPage.getDropListDescription()
                .shouldHave(CollectionCondition.size(catalogPage.getDropListElements().size()));
        dropListDescription.forEach(element -> element.shouldBe(Condition.visible));
    }
}
