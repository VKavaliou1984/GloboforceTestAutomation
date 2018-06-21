package com.epam.tat.webdriver.scenarios.clientsites;

import com.epam.tat.webdriver.bo.NominationBO;
import com.epam.tat.webdriver.factory.UserFactory;
import com.epam.tat.webdriver.pages.clientsites.blocks.HeaderBlock;
import com.epam.tat.webdriver.pages.clientsites.nomination.NominationConfirmationPage;
import com.epam.tat.webdriver.scenarios.BaseTest;
import com.epam.tat.webdriver.service.clientsites.LoginClientSiteService;
import com.epam.tat.webdriver.service.clientsites.NominationService;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

public class CreateCustomNominationTest extends BaseTest {

    private static final String RECIPIENT = "Helen HR_Manager";
    private static final String AWARD_REASON = "REASON3";
    private static final String AWARD_LEVEL = "Award5";
    private static final String AWARD_TITLE = "Auto_test_vk_award_test_title";
    private static final String AWARD_MESSAGE = "Auto_test_vk_award_test_message";
    private static final String AWARD_APPROVAL_MESSAGE = "Auto_test_vk_award_test_message_for_approver";

    @Test(description = "Create custom nomination Test")
    public void createNomination() {
        LoginClientSiteService.loginClientSite(new UserFactory().get5015User());
        NominationService.createNomination(new NominationBO.Builder(RECIPIENT, AWARD_TITLE, AWARD_MESSAGE)
                .chooseAwardReason(AWARD_REASON)
                .chooseAwardType(AWARD_LEVEL)
                .addMessageForApprover(AWARD_APPROVAL_MESSAGE)
                .build());
        Assert.assertTrue(new NominationConfirmationPage().isNominationSubmitted(),
                "Required elements ('close' button or 'nominate another colleague') for NominationBO Confirmation Page are not found:");
    }

    @AfterClass
    public void completeNominationProcess() {
        new NominationConfirmationPage().completeNominationProcess();
        new HeaderBlock().signOut();
    }
}
