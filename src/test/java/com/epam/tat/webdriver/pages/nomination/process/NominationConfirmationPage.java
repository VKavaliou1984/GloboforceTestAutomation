package com.epam.tat.webdriver.pages.nomination.process;

import com.epam.tat.webdriver.pages.LandingPage;
import com.epam.tat.webdriver.pages.Nomination;
import org.openqa.selenium.By;

import static com.epam.tat.webdriver.Service.Waiters.waitElementClickable;
import static com.epam.tat.webdriver.Service.Waiters.waitElementClosed;

public class NominationConfirmationPage extends Nomination {

    private By completeNominationButtonBy = By.xpath("//button[contains(@class,'js-np-close')]");

    public LandingPage completeNominationProcess() {
        if (isNominationPopUpOpened()) {
            waitElementClickable(driver, completeNominationButtonBy).click();
            waitElementClosed(driver, getNominationPopUpBy());
        }
        return new LandingPage();
    }
}
