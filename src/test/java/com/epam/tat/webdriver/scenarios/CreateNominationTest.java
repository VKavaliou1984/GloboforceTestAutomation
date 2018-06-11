package com.epam.tat.webdriver.scenarios;

import com.epam.tat.webdriver.bo.NominationBO;
import com.epam.tat.webdriver.bo.UserBO;
import com.epam.tat.webdriver.pages.clientsites.blocks.HeaderBlock;
import com.epam.tat.webdriver.pages.clientsites.nomination.NominationConfirmationPage;
import com.epam.tat.webdriver.service.LoginClientSiteService;
import com.epam.tat.webdriver.service.NominationService;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

public class CreateNominationTest extends BaseTest {

    private static final String CLIENT_NAME = "testclient5015";
    private static final String USER_NAME = "adam_admin";
    private static final String PASSWORD = "password1";
    private static final String SERVER = "staging-web1.corp.globoforce.com"; //"psupport-web1.corp.globoforce.com"; //preprod-sandbox0.corp.globoforce.com //sandbox0.globoforce.com //psupport-sandbox0.corp.globoforce.com //psupport-web1.corp.globoforce.com
    private static final String RECIPIENT = "Helen HR_Manager";
    private static final String AWARD_TITLE = "Auto_test_vk_award_test_title";
    private static final String AWARD_MESSAGE = "Auto_test_vk_award_test_message";
    private static final String AWARD_APPROVAL_MESSAGE = "Auto_test_vk_award_test_message_for_approver";

    @Test(description = "Create nomination Test")
    public void createNomination() {
        LoginClientSiteService.loginClientSite(new UserBO(USER_NAME, PASSWORD, CLIENT_NAME, SERVER));
        NominationService.createNomination(new NominationBO(RECIPIENT, null, null, AWARD_TITLE, AWARD_MESSAGE, AWARD_APPROVAL_MESSAGE, null, null));
        Assert.assertTrue(new NominationConfirmationPage().isNominationSubmitted(),
                "Required elements ('close' button or 'nominate another colleague') for NominationBO Confirmation Page are not found:");
    }

    @AfterClass
    public void completeNominationProcess() {
        new NominationConfirmationPage().completeNominationProcess();
        new HeaderBlock().signOut();
    }
}
