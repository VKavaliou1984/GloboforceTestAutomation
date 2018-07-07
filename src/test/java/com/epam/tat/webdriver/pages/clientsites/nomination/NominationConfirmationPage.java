package com.epam.tat.webdriver.pages.clientsites.nomination;

import com.epam.tat.webdriver.pages.clientsites.LandingPage;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.TextInput;

import static com.epam.tat.webdriver.utilities.Waiters.waitElementClickable;
import static com.epam.tat.webdriver.utilities.Waiters.waitElementDisplayed;

public class NominationConfirmationPage extends NominationPage {

    @Name("Complete nomination process button")
    @FindBy(xpath = "//button[contains(@class,'js-np-close')]")
    private TextInput completeNominationButton;

    @Name("Nominate Another Colleague Button")
    @FindBy(xpath = "//a[contains(@class,'np-new-nomination')]")
    private Button nominateAnotherColleagueButton;

    @Name("Sign Out button")
    @FindBy(xpath = "//a[contains(@href,'logout')]")
    private Button signOutButton;

    public LandingPage completeNominationProcess() {
        logger.info("Completing nomination process");
        waitElementClickable(driver, completeNominationButton).click();
        waitElementDisplayed(driver, signOutButton);
        return new LandingPage();
    }

    public boolean isNominationSubmitted() {
        return isNominationPopUpOpened() && waitElementClickable(driver, completeNominationButton).isDisplayed() &
                waitElementClickable(driver, nominateAnotherColleagueButton).isDisplayed();
    }
}
