package com.epam.tat.webdriver.pages.nomination.process;

import com.epam.tat.webdriver.Service.InputFieldFilling;
import com.epam.tat.webdriver.pages.NominationPage;
import org.openqa.selenium.By;

import static com.epam.tat.webdriver.Service.Waiters.waitElementClickable;

public class AwardDetailsPage extends NominationPage {

    private By awardTitleInputBy = By.id("np_awardTitle");
    private By awardMessageInputBy = By.id("np_awardMessage");
    private By messageForApprovalInputBy = By.id("np_messageForApproval");
    private By submitNominationButtonBy = By.xpath("//button[contains(@class,'js-np-send-award')]");

    private Boolean isAwardMessageInputDisplayed() {
        try {
            driver.findElement(messageForApprovalInputBy);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    public AwardDetailsPage fillingAwardTitle(String awardTitle) {
        InputFieldFilling.fillInputField(driver, awardTitleInputBy, awardTitle);
        return this;
    }

    public AwardDetailsPage fillingAwardMessage(String awardMessage) {
        InputFieldFilling.fillInputField(driver, awardMessageInputBy, awardMessage);
        return this;
    }

    public AwardDetailsPage fillingAwardApprovalMessage(String awardApprovalMessage) {
        if (isAwardMessageInputDisplayed()) {
            InputFieldFilling.fillInputField(driver, messageForApprovalInputBy, awardApprovalMessage);
        }
        return this;
    }

    public NominationConfirmationPage submitNomination() {
        waitElementClickable(driver, submitNominationButtonBy).click();
        return new NominationConfirmationPage();
    }
}
