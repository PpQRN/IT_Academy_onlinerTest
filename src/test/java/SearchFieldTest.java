import com.codeborne.selenide.Condition;
import it_academy.links.Links;
import it_academy.pageobject.Header;
import it_academy.pageobject.SearchCatalogDropList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SearchFieldTest extends BaseTest {

    @BeforeEach
    public void goToMainPage(){
        goToPage(Links.homepage);
    }

    @Test
    public void innerBaseTextTest(){
        new Header()
                .getInnerSearchText()
                .shouldBe(Condition.visible)
                .shouldHave(Condition.attributeMatching
                ("placeholder", "Поиск в Каталоге.*"));
    }

    @Test
    public void searchFieldOpensCatalogPageTest() throws InterruptedException {
        new Header()
                .clickOnSearchField()
                .enterText("Телефон")
                .getDropField()
                .shouldBe(Condition.visible);
    }


}
