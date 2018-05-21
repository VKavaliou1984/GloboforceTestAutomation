package com.epam.tat.webdriver.scenarios;

import com.epam.tat.webdriver.pages.LoginPage;
import com.epam.tat.webdriver.pages.blocks.HeaderBlock;
import com.epam.tat.webdriver.pages.nomination.process.AwardReasonsPage;
import com.epam.tat.webdriver.service.driver.WebDriverInitializator;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import java.util.Arrays;

public class AwardReasonsComparisonTest extends BaseTest {

    private static final String RECIPIENT = "Helen HR_Manager";

    @Test(description = "Compare award reasons description values Test")
    public void createNomination() {
        new LoginPage().
                open(SERVER, CLIENT_NAME)
                .enterUserName(USER_NAME)
                .enterPassword(PASSWORD)
                .clickSignIn()
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
