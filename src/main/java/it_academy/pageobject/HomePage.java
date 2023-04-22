package it_academy.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Quotes;

import static java.lang.String.format;

public class HomePage extends BasePage {

    ////li[@class = 'catalog-navigation-classifier__item ']//span[contains(@class, 'wrapper')]
    private static final String SECTION_LINK_XPATH_PATTERN =
            "//*[contains(@class, 'section-title')]//h1[contains(text(), %s)]";

    public ContactUsPage clickOnSectionLink(String link) {
        waitForElementVisible(By.xpath(format(SECTION_LINK_XPATH_PATTERN, Quotes.escape(link))))
                .click();
        return new ContactUsPage();
    }
}