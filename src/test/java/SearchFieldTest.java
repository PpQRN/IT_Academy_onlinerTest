import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.SelenideWait;
import it_academy.links.Links;

import static com.codeborne.selenide.Condition.*;

import it_academy.pageobject.Header;
import it_academy.pageobject.SearchCatalogDropList;
import it_academy.pageobject.SearchFieldFrame;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

import static com.codeborne.selenide.Selenide.Wait;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

public class SearchFieldTest extends BaseTest {
    Header header = new Header();
    SearchFieldFrame searchFieldFrame = new SearchFieldFrame();

    @BeforeEach
    public void goToMainPage() {
        goToPage(Links.homepage);
    }

    @Test
    public void innerBaseTextTest() {
        header.getInnerSearchText()
                .shouldBe(Condition.visible)
                .shouldHave(Condition.attributeMatching
                        ("placeholder", "Поиск в Каталоге.*"));
    }

    @Test
    public void searchFieldResultsAreVisibleTest() {
        header.clickOnSearchField()
                .enterText("Телефон")
                .switchToSearchFieldFrame()
                .getSearchResults()
                .shouldBe(Condition.visible);
    }

    @Test
    public void searchRandomQueryTest() {
        header.clickOnSearchField()
                .enterText("fdsafkosdfkoakoasfkd")
                .switchToSearchFieldFrame()
                .getSearchResults()
                .shouldNotBe(Condition.visible);
    }


    /*Не знаю, как проверить по другому, так как при проверке
     * enterText("Телефон")
     * getSearchResults()
     * shouldNotBe(Condition.visible);
     * Выдаёт что тест пройден, так как результаты изначально не видны и прогружатся спустя какое-то время после ввода
     * и тест на shouldNotBe(Condition.visible); Пройдёт при любом вводе. не хотелось просто ждать какое-либо время ожидая пока всё прогрузится
     * поэтому тест представляет из себя ввод данных, ожидание пока они появятся и потом их стирание и подтверждение того
     * что поле результата пустое
     * */
    @Test
    public void searchFieldEmptyQueryTest() {
        header.clickOnSearchField()
                .enterText("Телефон")
                .switchToSearchFieldFrame()
                .getSearchResults()
                .shouldBe(Condition.visible);
        new SearchFieldFrame()
                .clearSearchField()
                .getSearchResults()
                .shouldNotBe(visible);
    }

    @Test
    public void areSearchTabsItemsExistTest() {
        List<SelenideElement> tabsItems = header.clickOnSearchField()
                .enterText("Телефон")
                .switchToSearchFieldFrame()
                .getSearchTabItems();
        tabsItems.forEach(element -> element.shouldBe(Condition.visible));
    }

    @Test
    public void isImageWorksAsALinkTest()  {
        String url = header.clickOnSearchField()
                .enterText("Телефон")
                .switchToSearchFieldFrame()
                .clickOnProductImage()
                .getCurrentURL();
        assertThat(url).contains("catalog.onliner.by");
    }

    @Test
    public void isOfferButtonLeadsToPricesPage()  {
        String url = header.clickOnSearchField()
                .enterText("Телефон")
                .switchToSearchFieldFrame()
                .clickOnOfferButton()
                .getCurrentURL();
        assertThat(url).contains("prices");
    }

    @Test
    public void isOfferButtonsDisplayed(){
        List<SelenideElement> offerButtons = header.clickOnSearchField()
                .enterText("   ")
                .switchToSearchFieldFrame()
                .getOfferButtons()
                .shouldBe(CollectionCondition.size(searchFieldFrame.getItemProducts().size()))
                .shouldBe(CollectionCondition.sizeGreaterThan(0));
        offerButtons.forEach(element -> element.shouldBe(visible));
    }

}
