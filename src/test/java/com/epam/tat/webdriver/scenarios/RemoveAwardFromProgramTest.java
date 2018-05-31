package com.epam.tat.webdriver.scenarios;

import com.epam.tat.webdriver.pages.iaf.IAFLoginPage;
import com.epam.tat.webdriver.pages.iaf.configapp.awards.awardprograms.AwardProgramsPage;
import com.epam.tat.webdriver.pages.iaf.configapp.awards.awardprograms.AwardTypesDialogPage;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

public class RemoveAwardFromProgramTest extends BaseTest {

    private static final String IAF_USER_NAME = "bhkb.jshcw@gqfozpkzgb.kbk";
    private static final String MAPPING_AWARD_NAME = "Award2";
    private static final String AWARD_PROGRAM_NAME = "testclient5021 program";

    @Test(description = "Unmapping (Removing) Award Level from Program Test")
    public void removeAwardLevel() {
        new IAFLoginPage()
                .openIAFLoginPage()
                .enterUserName(IAF_USER_NAME)
                .enterPassword(PASSWORD)
                .clickIAFSignIn()
                .clickConfigAppButton()
                .clickChooseClientButton()
                .clickAwardsButton()
                .clickAwardProgramsButton()
                .clickAwardTypesDialog(AWARD_PROGRAM_NAME)
                .unmapAwardFromProgram(MAPPING_AWARD_NAME)
                .saveAwardMapping();
        Assert.assertNotEquals(MAPPING_AWARD_NAME, new AwardTypesDialogPage().findAwardLevel(MAPPING_AWARD_NAME));
    }

    @AfterClass
    public void signOutFromIAF() {
        new AwardProgramsPage().clickSignOutButton();
    }
}
