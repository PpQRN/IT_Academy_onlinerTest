import it_academy.pageobject.ContactUsPage;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ContactUsFormTest extends BaseTest {
    private ContactUsPage contactUsPage = new ContactUsPage();

    @BeforeClass
    public void navigateToHomePage() {
        //все URL тестируемогот портала нужно вынести в отдельный классб напр. enum на уровень java
        contactUsPage.navigate("https://www.onliner.by/");
    }

    @Test
    public void testContactUsFormSubmitting() {
        String expectedReplyMessage = "Thank You for your Message!";
        String actualReplyMessage = contactUsPage.fillInContactUsForm()
                .clickOnButton("SUBMIT")
                .getFormContactFormReplyMessage();
        assertThat(actualReplyMessage)
                .as("Message after form submitting is incorrect")
                .isEqualTo(expectedReplyMessage);
    }
}