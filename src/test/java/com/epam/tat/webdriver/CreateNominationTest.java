package com.epam.tat.webdriver;

import com.epam.tat.webdriver.Service.Driver.BrowserType;
import com.epam.tat.webdriver.Service.Driver.WebDriverInitializator;
import com.epam.tat.webdriver.pages.LoginPage;
import com.epam.tat.webdriver.pages.blocks.HeaderBlock;
import org.testng.Assert;
import org.testng.annotations.*;

public class CreateNominationTest {
    private static final String URL = "https://%s/microsites/t/home?client=%s";
    private static final String CLIENT_NAME = "testclient5015";
    private static final String USER_NAME = "adam_admin";
    private static final String PASSWORD = "password1";
    private static final String SERVER = "staging-web1.corp.globoforce.com"; //"psupport-web1.corp.globoforce.com"; //preprod-sandbox0.corp.globoforce.com //sandbox0.globoforce.com //psupport-sandbox0.corp.globoforce.com //psupport-web1.corp.globoforce.com
    private static final String RECIPIENT = "Helen HR_Manager";
    private static final String AWARD_TITLE = "Auto_test_vk_award_test_title";
    private static final String AWARD_MESSAGE = "Auto_test_vk_award_test_message";
    private static final String AWARD_APPROVAL_MESSAGE = "Auto_test_vk_award_test_message_for_approver";

    @BeforeClass
    @Parameters({"browser"})
    public void initializeDriver(@Optional("FIREFOX") BrowserType browser) {
        WebDriverInitializator.getInstance().startDriver(browser);
    }

    @Test(description = "Create nomination Test")
    public void createNomination() {
        new LoginPage().open(URL, SERVER, CLIENT_NAME)
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
                .submitNomination()
                .completeNominationProcess();
        Assert.assertEquals(WebDriverInitializator.getInstance().getDriver().getTitle(), "Welcome", "Incorrect page");
    }

    @AfterClass(alwaysRun = true)
    public void closeDriver() {
        HeaderBlock headerBlock = new HeaderBlock();
        headerBlock.clickSignOut();
        WebDriverInitializator.getInstance().closeDriver();
    }
}
