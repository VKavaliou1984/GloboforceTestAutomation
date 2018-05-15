package com.epam.tat.webdriver.scenarios;

import com.epam.tat.webdriver.pages.LoginPage;
import com.epam.tat.webdriver.pages.blocks.HeaderBlock;
import com.epam.tat.webdriver.pages.nomination.process.NominationConfirmationPage;
import com.epam.tat.webdriver.service.driver.BrowserType;
import com.epam.tat.webdriver.service.driver.WebDriverInitializator;
import org.testng.Assert;
import org.testng.annotations.*;

public class CreateNominationTest {
    private static final String CLIENT_NAME = "testclient5015";
    private static final String USER_NAME = "adam_admin";
    private static final String PASSWORD = "password1";
    private static final String SERVER = "staging-web1.corp.globoforce.com"; //"psupport-web1.corp.globoforce.com";
    private static final String RECIPIENT = "Helen HR_Manager";
    private static final String AWARD_TITLE = "Auto_test_vk_award_test_title";
    private static final String AWARD_MESSAGE = "Auto_test_vk_award_test_message";
    private static final String AWARD_APPROVAL_MESSAGE = "Auto_test_vk_award_test_message_for_approver";

    @BeforeClass
    @Parameters({"browser"})
    public void initializeDriver(@Optional("CHROME") BrowserType browser) {
        System.out.println("Browser in use: ".concat(browser.toString()));
        WebDriverInitializator.
                getInstance().
                startDriver(browser);
    }

    @Test(description = "Create nomination Test")
    public void createNomination() {
        new LoginPage().open(SERVER, CLIENT_NAME)
                .enterUserName(USER_NAME)
                .enterPassword(PASSWORD)
                .clickSignIn()
                .clickRecognizeButton()
                .searchRecipient(RECIPIENT).clickNext()
                .chooseDefaultProgram()
                .chooseAwardReason()
                .chooseAwardReason()
                .fillingAwardTitle(AWARD_TITLE)
                .fillingAwardMessage(AWARD_MESSAGE)
                .fillingAwardApprovalMessage(AWARD_APPROVAL_MESSAGE)
                .submitNomination();
        Assert.assertTrue(new NominationConfirmationPage().isNominationSubmitted(),
                "Required elements ('close' button or 'nominate another colleague') for Nomination Confirmation Page are not found:");
    }

    @AfterClass(alwaysRun = true)
    public void closeDriver() {
        new NominationConfirmationPage().completeNominationProcess();
        new HeaderBlock().clickSignOut();
        WebDriverInitializator.getInstance().closeDriver();
    }
}
