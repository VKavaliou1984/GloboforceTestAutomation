package com.epam.tat.webdriver.pages.nomination.process;

import com.epam.tat.webdriver.pages.Nomination;
import org.openqa.selenium.By;

import static com.epam.tat.webdriver.Service.Waiters.waitElementClickable;

public class ClientProgramsPage extends Nomination {

    private By defaultAwardProgramButtonBy = By.xpath("//div[contains(@class,'np-award-program-default')]");

    public ReasonsPage chooseDefaultProgram() {
        waitElementClickable(driver, defaultAwardProgramButtonBy).click();
        return new ReasonsPage();
    }

}
