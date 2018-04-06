package com.epam.tat.webdriver.pages.nomination.process;

import com.epam.tat.webdriver.pages.Nomination;
import org.openqa.selenium.By;

import static com.epam.tat.webdriver.Service.Waiters.waitElementClickable;

public class ReasonsPage extends Nomination {

    private By awardReasonButtonBy = new By.ByXPath("//div[contains(@class,'np-award-reason-item')]");

    public AwardLevelsPage chooseAwardReason() {
        waitElementClickable(driver, awardReasonButtonBy).click();
        return new AwardLevelsPage();
    }
}
