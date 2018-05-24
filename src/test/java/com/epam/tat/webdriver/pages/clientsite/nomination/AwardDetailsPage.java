package com.epam.tat.webdriver.pages.clientsite.nomination;

import com.epam.tat.webdriver.service.InputFieldFilling;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.TextInput;

import static com.epam.tat.webdriver.service.Waiters.waitElementClickable;

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
        try {
            messageForApprovalInput.isDisplayed();
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    public AwardDetailsPage fillAwardTitle(String awardTitle) {
        InputFieldFilling.fillInputField(driver, awardTitleInput, awardTitle);
        return this;
    }

    public AwardDetailsPage fillAwardMessage(String awardMessage) {
        InputFieldFilling.fillInputField(driver, awardMessageInput, awardMessage);
        return this;
    }

    public AwardDetailsPage fillAwardApprovalMessage(String awardApprovalMessage) {
        if (isAwardMessageInputDisplayed()) {
            InputFieldFilling.fillInputField(driver, messageForApprovalInput, awardApprovalMessage);
        }
        return this;
    }

    public NominationConfirmationPage submitNomination() {
        waitElementClickable(driver, submitNominationButton).click();
        return new NominationConfirmationPage();
    }
}
