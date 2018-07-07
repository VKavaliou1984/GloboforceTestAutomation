package com.epam.tat.webdriver.pages.clientsites.nomination;

import com.epam.tat.webdriver.pages.BasePage;
import com.epam.tat.webdriver.pages.clientsites.LandingPage;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.HtmlElement;

import static com.epam.tat.webdriver.utilities.Waiters.waitElementClickable;
import static com.epam.tat.webdriver.utilities.Waiters.waitElementDisplayed;

public class NominationPage extends BasePage {

    @Name("In page nomination layer (nomination popUp)")
    @FindBy(id = "np_mainNotification")
    private HtmlElement nominationPopUp;

    @Name("Close nomination popUp (Cancel nomination process)")
    @FindBy(xpath = "//button[contains(@class,'gf-drawer-button-close')]")
    private Button closeNominationProcessButton;

    protected boolean isNominationPopUpOpened() {
        try {
            waitElementDisplayed(driver, nominationPopUp);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    public LandingPage closeNominationProcess() {
        logger.info("Closing nomination pop-up window");
        waitElementClickable(driver, closeNominationProcessButton).click();
        return new LandingPage();
    }
}
