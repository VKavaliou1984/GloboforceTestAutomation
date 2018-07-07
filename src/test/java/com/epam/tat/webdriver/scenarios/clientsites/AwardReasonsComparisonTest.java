package com.epam.tat.webdriver.scenarios.clientsites;

import com.epam.tat.webdriver.factory.UserFactory;
import com.epam.tat.webdriver.pages.clientsites.blocks.HeaderBlock;
import com.epam.tat.webdriver.pages.clientsites.nomination.AwardReasonsPage;
import com.epam.tat.webdriver.scenarios.BaseTest;
import com.epam.tat.webdriver.service.clientsites.LoginClientSiteService;
import com.epam.tat.webdriver.utilities.driver.WebDriverInitializator;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import java.util.Arrays;

public class AwardReasonsComparisonTest extends BaseTest {

    private static final String RECIPIENT = "Helen HR_Manager";

    @Test(description = "Compare awards reasons description values Test")
    public void createNomination() {
        logger.info("Comparing awards reasons description");
        LoginClientSiteService.loginClientSite(new UserFactory().get5015User())
                .clickRecognizeButton()
                .searchRecipient(RECIPIENT)
                .clickNext()
                .chooseDefaultProgram();
        Assert.assertEquals(new AwardReasonsPage().getAwardReasonsDescription(),
                Arrays.asList("REASON121", "REASON2", "REASON3", "REASON4", "REASON5", "REASON6"),
                "Award reasons descriptions aren't equal requirements:");
    }

    @AfterClass(alwaysRun = true)
    public void closeDriver() {
        new AwardReasonsPage().closeNominationProcess();
        new HeaderBlock().signOut();
        WebDriverInitializator.getInstance().quitDriver();
    }

}
