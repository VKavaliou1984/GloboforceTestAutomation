package com.epam.tat.webdriver.pages.nomination.process;

import com.epam.tat.webdriver.pages.LandingPage;
import com.epam.tat.webdriver.pages.NominationPage;
import org.openqa.selenium.By;

import static com.epam.tat.webdriver.service.Waiters.waitElementClickable;
import static com.epam.tat.webdriver.service.Waiters.waitElementClosed;

public class NominationConfirmationPage extends NominationPage {

    private By completeNominationButtonBy = By.xpath("//button[contains(@class,'js-np-close')]");
    private By nominateAnotherColleagueButtonBy = By.xpath("//a[contains(@class,'np-new-nomination')]");

    public LandingPage completeNominationProcess() {
        if (isNominationPopUpOpened()) {
            waitElementClickable(driver, completeNominationButtonBy).click();
            waitElementClosed(driver, getNominationPopUpBy());
        }
        return new LandingPage();
    }

    public boolean isNominationSubmitted() {
        if (isNominationPopUpOpened()) {
            return waitElementClickable(driver, completeNominationButtonBy).isDisplayed() &
                    waitElementClickable(driver, nominateAnotherColleagueButtonBy).isDisplayed();
        }
        return false;
    }
}
