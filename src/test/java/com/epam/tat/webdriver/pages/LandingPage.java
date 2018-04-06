package com.epam.tat.webdriver.pages;

import com.epam.tat.webdriver.pages.nomination.process.RecipientSelectPage;
import org.openqa.selenium.By;

import static com.epam.tat.webdriver.Service.Waiters.waitElementClickable;
import static com.epam.tat.webdriver.Service.Waiters.waitElementDisplayed;

public class LandingPage extends BasePage {

    private By recognizeButtonBy = By.id("giveAward");
    private By inPageNominationLayerBy = By.id("np_mainSelectRecipients");

    public RecipientSelectPage clickRecognizeButton() {
        waitElementClickable(driver, recognizeButtonBy).click();
        waitElementDisplayed(driver, inPageNominationLayerBy);
        return new RecipientSelectPage();
    }
}
