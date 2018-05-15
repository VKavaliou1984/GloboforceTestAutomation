package com.epam.tat.webdriver.pages;

import com.epam.tat.webdriver.pages.nomination.process.RecipientSelectPage;
import org.openqa.selenium.By;

import static com.epam.tat.webdriver.service.Waiters.waitElementClickable;

public class LandingPage extends BasePage {

    private By recognizeButtonBy = By.id("giveAward");

    public RecipientSelectPage clickRecognizeButton() {
        waitElementClickable(driver, recognizeButtonBy).click();
        return new RecipientSelectPage();
    }
}
