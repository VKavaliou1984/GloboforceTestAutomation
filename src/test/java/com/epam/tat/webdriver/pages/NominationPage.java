package com.epam.tat.webdriver.pages;

import org.openqa.selenium.By;

import static com.epam.tat.webdriver.Service.Waiters.waitElementDisplayed;

public abstract class NominationPage extends BasePage {

    private By nominationPopUpBy = By.id("np_mainNotification");


    protected boolean isNominationPopUpOpened() {
        try {
            waitElementDisplayed(driver, nominationPopUpBy);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    public By getNominationPopUpBy() {
        return nominationPopUpBy;
    }
}


