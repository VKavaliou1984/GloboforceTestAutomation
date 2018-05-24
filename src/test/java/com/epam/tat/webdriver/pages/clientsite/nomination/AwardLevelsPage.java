package com.epam.tat.webdriver.pages.clientsite.nomination;

import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.Button;

import static com.epam.tat.webdriver.service.Waiters.waitElementClickable;

public class AwardLevelsPage extends NominationPage {

    @Name("Award level button")
    @FindBy(xpath = "//div[contains(@class,'np-award-value-wrapper')]")
    private Button awardLevelsButton;

    public AwardDetailsPage chooseAwardLevel() {
        waitElementClickable(driver, awardLevelsButton).click();
        return new AwardDetailsPage();
    }
}
