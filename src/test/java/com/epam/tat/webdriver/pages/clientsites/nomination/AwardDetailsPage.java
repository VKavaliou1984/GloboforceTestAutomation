package com.epam.tat.webdriver.pages.clientsites.nomination;

import com.epam.tat.webdriver.utilities.InputFieldFilling;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.TextInput;

import static com.epam.tat.webdriver.utilities.Waiters.waitElementClickable;

public class AwardDetailsPage extends NominationPage {

    @Name("Award title input field")
    @FindBy(id = "np_awardTitle")
    private TextInput awardTitleInput;

    @Name("Award message input field")
    @FindBy(id = "np_awardMessage")
    private TextInput awardMessageInput;

    @Name("Award message for approver input field")
    @FindBy(id = "np_messageForApproval")
    private TextInput messageForApprovalInput;

    @Name("Submit nomination button")
    @FindBy(xpath = "//button[contains(@class,'js-np-send-award')]")
    private Button submitNominationButton;

    private Boolean isAwardMessageInputDisplayed() {
        logger.info("Check whether award message for approver is displayed");
        try {
            messageForApprovalInput.isDisplayed();
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    public AwardDetailsPage fillAwardTitle(String awardTitle) {
        logger.info("Filling award title");
        InputFieldFilling.fillInputField(driver, awardTitleInput, awardTitle);
        return this;
    }

    public AwardDetailsPage fillAwardMessage(String awardMessage) {
        logger.info("Filling award message");
        InputFieldFilling.fillInputField(driver, awardMessageInput, awardMessage);
        return this;
    }

    public AwardDetailsPage fillAwardApprovalMessage(String awardApprovalMessage) {
        if (isAwardMessageInputDisplayed()) {
            logger.info("Filling award message for approver");
            InputFieldFilling.fillInputField(driver, messageForApprovalInput, awardApprovalMessage);
        }
        return this;
    }

    public NominationConfirmationPage submitNomination() {
        logger.info("Submitting a nomination");
        waitElementClickable(driver, submitNominationButton).click();
        return new NominationConfirmationPage();
    }
}
