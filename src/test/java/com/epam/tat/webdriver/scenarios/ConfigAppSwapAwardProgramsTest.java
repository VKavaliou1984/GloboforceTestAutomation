package com.epam.tat.webdriver.scenarios;

import com.epam.tat.webdriver.pages.iaf.IAFLoginPage;
import com.epam.tat.webdriver.pages.iaf.IAFMainPage;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

public class ConfigAppSwapAwardProgramsTest extends BaseTest {

    private static final String IAF_USER_NAME = "bhkb.jshcw@gqfozpkzgb.kbk";

    @Test(description = "Swap Award Programs Test")
    public void swapAwardPrograms() {
        new IAFLoginPage()
                .openIAFLoginPage()
                .enterUserName(IAF_USER_NAME)
                .enterPassword(PASSWORD)
                .clickIAFSignIn()
                .clickConfigAppButton()
                .clickChooseClientButton()
                .clickAwardsButton()
                .clickAwardProgramsButton()
                .swapAwardPrograms();
    }

    @AfterClass
    public void signOutFromIAF() {
        new IAFMainPage().clickSignOutButton();
    }
}
