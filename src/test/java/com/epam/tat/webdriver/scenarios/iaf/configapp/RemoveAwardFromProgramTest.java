package com.epam.tat.webdriver.scenarios.iaf.configapp;

import com.epam.tat.webdriver.factory.UserFactory;
import com.epam.tat.webdriver.pages.iaf.configapp.awards.awardprograms.AwardProgramsPage;
import com.epam.tat.webdriver.pages.iaf.configapp.awards.awardprograms.AwardTypesDialogPage;
import com.epam.tat.webdriver.scenarios.BaseTest;
import com.epam.tat.webdriver.service.iaf.LoginIafService;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

public class RemoveAwardFromProgramTest extends BaseTest {

    private static final String MAPPING_AWARD_NAME = "Award2";
    private static final String AWARD_PROGRAM_NAME = "testclient5021 program";

    @Test(description = "Unmapping (Removing) Award Level from Program Test")
    public void removeAwardLevel() {
        LoginIafService.loginIaf((new UserFactory().getIafUser()))
                .clickConfigAppButton()
                .clickChooseClientButton()
                .clickAwardsButton()
                .clickAwardProgramsButton()
                .clickAwardTypesDialog(AWARD_PROGRAM_NAME)
                .unmapAwardFromProgram(MAPPING_AWARD_NAME)
                .saveAwardMapping()
                .waitUntilChangesSaved()
                .clickAwardTypesDialog(AWARD_PROGRAM_NAME);
        Assert.assertNull(new AwardTypesDialogPage().findAwardLevel(MAPPING_AWARD_NAME, true));
    }

    @AfterClass
    public void cleanUp() {
        new AwardTypesDialogPage()
                .mapAwardToProgram(MAPPING_AWARD_NAME)
                .saveAwardMapping()
                .waitUntilChangesSaved();
    }

    @AfterClass(dependsOnMethods = "cleanUp")
    public void signOutFromIAF() {
        new AwardProgramsPage().clickSignOutButton();
    }
}
