package com.epam.tat.webdriver.scenarios;

import com.epam.tat.webdriver.bo.UserBO;
import com.epam.tat.webdriver.pages.clientsites.blocks.HeaderBlock;
import com.epam.tat.webdriver.pages.clientsites.nomination.AwardReasonsPage;
import com.epam.tat.webdriver.service.LoginClientSiteService;
import com.epam.tat.webdriver.utilities.driver.WebDriverInitializator;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import java.util.Arrays;

public class AwardReasonsComparisonTest extends BaseTest {

    private static final String CLIENT_NAME = "testclient5015";
    private static final String USER_NAME = "adam_admin";
    private static final String PASSWORD = "password1";
    private static final String SERVER = "staging-web1.corp.globoforce.com"; //"psupport-web1.corp.globoforce.com"; //preprod-sandbox0.corp.globoforce.com //sandbox0.globoforce.com //psupport-sandbox0.corp.globoforce.com //psupport-web1.corp.globoforce.com
    private static final String RECIPIENT = "Helen HR_Manager";

    @Test(description = "Compare awards reasons description values Test")
    public void createNomination() {
        LoginClientSiteService.loginClientSite(new UserBO(USER_NAME, PASSWORD, CLIENT_NAME, SERVER))
                .clickRecognizeButton()
                .searchRecipient(RECIPIENT)
                .clickNext()
                .chooseDefaultProgram();
        Assert.assertEquals(new AwardReasonsPage().getAwardReasonsDescription(),
                Arrays.asList("REASON1", "REASON2", "REASON3", "REASON4", "REASON5", "REASON6"),
                "Award reasons descriptions aren't equal requirements:");
    }

    @AfterClass(alwaysRun = true)
    public void closeDriver() {
        new AwardReasonsPage().closeNominationProcess();
        new HeaderBlock().signOut();
        WebDriverInitializator.getInstance().quitDriver();
    }

}
