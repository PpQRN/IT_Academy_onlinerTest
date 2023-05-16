package Web;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.*;

import it_academy.links.Links;
import it_academy.pageobject.Header;
import it_academy.pageobject.SearchFieldFrame;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

//@Execution(ExecutionMode.CONCURRENT)
public class SearchFieldTest extends BaseTest {
    private final Header header = new Header();
    private final SearchFieldFrame searchFieldFrame = new SearchFieldFrame();

    @BeforeEach
    public void goToMainPage() {
        open(Links.HOMEPAGE.getLink());
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

    @Test
    public void searchFieldEmptyQueryTest() {
        header.clickOnSearchField()
                .enterText(" ")
                .switchToSearchFieldFrame()
                .getSearchResults()
                .shouldNotBe(Condition.visible);
    }

    @Test
    public void areSearchTabsItemsExistTest() {
        List<SelenideElement> tabsItems = header.clickOnSearchField()
                .enterText(" ")
                .switchToSearchFieldFrame()
                .getSearchTabItems().shouldBe(CollectionCondition.sizeGreaterThan(0));
        tabsItems.forEach(element -> element.shouldBe(Condition.visible));
    }

    @Test
    public void isImageWorksAsALinkTest() {
        String url = header.clickOnSearchField()
                .enterText("Телефон")
                .switchToSearchFieldFrame()
                .clickOnProductImage()
                .getCurrentURL();
        assertThat(url).contains("catalog.onliner.by");
    }

    @Test
    public void isOfferButtonLeadsToPricesPage() {
        String url = header.clickOnSearchField()
                .enterText("Телефон")
                .switchToSearchFieldFrame()
                .clickOnOfferButton()
                .getCurrentURL();
        assertThat(url).contains("prices");
    }

    @Test
    public void isOfferButtonsDisplayed() {
        List<SelenideElement> offerButtons = header.clickOnSearchField()
                .enterText("Телефон")
                .switchToSearchFieldFrame()
                .getOfferButtons()
                .shouldBe(CollectionCondition.sizeGreaterThan(0))
                .shouldBe(CollectionCondition.size(searchFieldFrame.getItemProducts().size()));
        offerButtons.forEach(element -> element.shouldBe(visible));
    }

    @Test
    public void isSearchResultsCorrectTest() {
        String input = "Телефон";
        List<SelenideElement> resultTitles = header.clickOnSearchField()
                .enterText(input)
                .switchToSearchFieldFrame()
                .getSearchResultsTitles(input)
                .shouldBe(CollectionCondition.sizeGreaterThan(0));
        List<String> resultTitlesText = resultTitles.stream()
                .map(SelenideElement::text)
                .filter(text -> text.toLowerCase()
                        .contains(input.toLowerCase())).toList();
        assertThat(resultTitlesText).hasSizeGreaterThan(0);
    }
}
