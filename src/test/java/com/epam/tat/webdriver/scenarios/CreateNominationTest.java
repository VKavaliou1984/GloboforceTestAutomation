package com.epam.tat.webdriver.scenarios;

import com.epam.tat.webdriver.pages.clientsite.LoginPage;
import com.epam.tat.webdriver.pages.clientsite.blocks.HeaderBlock;
import com.epam.tat.webdriver.pages.clientsite.nomination.NominationConfirmationPage;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

public class CreateNominationTest extends BaseTest {

    private static final String RECIPIENT = "Helen HR_Manager";
    private static final String AWARD_TITLE = "Auto_test_vk_award_test_title";
    private static final String AWARD_MESSAGE = "Auto_test_vk_award_test_message";
    private static final String AWARD_APPROVAL_MESSAGE = "Auto_test_vk_award_test_message_for_approver";

    @Test(description = "Create nomination Test")
    public void createNomination() {
        new LoginPage().
                open(SERVER, CLIENT_NAME)
                .enterUserName(USER_NAME)
                .enterPassword(PASSWORD)
                .clickSignIn()
                .clickRecognizeButton()
                .searchRecipient(RECIPIENT)
                .clickNext()
                .chooseDefaultProgram()
                .chooseAwardReason()
                .chooseAwardLevel()
                .fillAwardTitle(AWARD_TITLE)
                .fillAwardMessage(AWARD_MESSAGE)
                .fillAwardApprovalMessage(AWARD_APPROVAL_MESSAGE)
                .submitNomination();
        Assert.assertTrue(new NominationConfirmationPage().isNominationSubmitted(),
                "Required elements ('close' button or 'nominate another colleague') for Nomination Confirmation Page are not found:");
    }

    @AfterClass
    public void completeNominationProcess() {
        new NominationConfirmationPage().completeNominationProcess();
        new HeaderBlock().signOut();
    }
}
