package com.epam.tat.webdriver.pages.nomination.process;

import com.epam.tat.webdriver.pages.NominationPage;
import org.openqa.selenium.By;

import static com.epam.tat.webdriver.service.Waiters.waitElementClickable;

public class ClientProgramsPage extends NominationPage {

    private By defaultAwardProgramButtonBy = By.xpath("//div[contains(@class,'np-award-program-default')]");

    public ReasonsPage chooseDefaultProgram() {
        waitElementClickable(driver, defaultAwardProgramButtonBy).click();
        return new ReasonsPage();
    }
}
