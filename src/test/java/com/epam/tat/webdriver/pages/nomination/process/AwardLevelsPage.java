package com.epam.tat.webdriver.pages.nomination.process;

import com.epam.tat.webdriver.pages.Nomination;
import org.openqa.selenium.By;

import static com.epam.tat.webdriver.Service.Waiters.waitElementClickable;

public class AwardLevelsPage extends Nomination {

    private By awardLevelsButtonBy = By.xpath("(//div[contains(@class,'np-award-value-wrapper')])[last()]");

    public AwardDetailsPage chooseAwardReason() {
        waitElementClickable(driver, awardLevelsButtonBy).click();
        return new AwardDetailsPage();
    }
}
