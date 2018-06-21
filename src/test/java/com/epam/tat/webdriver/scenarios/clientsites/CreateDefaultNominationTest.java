package com.epam.tat.webdriver.scenarios.clientsites;

import com.epam.tat.webdriver.factory.NominationFactory;
import com.epam.tat.webdriver.factory.UserFactory;
import com.epam.tat.webdriver.pages.clientsites.blocks.HeaderBlock;
import com.epam.tat.webdriver.pages.clientsites.nomination.NominationConfirmationPage;
import com.epam.tat.webdriver.scenarios.BaseTest;
import com.epam.tat.webdriver.service.clientsites.LoginClientSiteService;
import com.epam.tat.webdriver.service.clientsites.NominationService;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

public class CreateDefaultNominationTest extends BaseTest {

    @Test(description = "Create default nomination Test")
    public void createNomination() {
        LoginClientSiteService.loginClientSite(new UserFactory().get5015User());
        NominationService.createNomination(new NominationFactory().getDefaultNomination());
        Assert.assertTrue(new NominationConfirmationPage().isNominationSubmitted(),
                "Required elements ('close' button or 'nominate another colleague') for NominationBO Confirmation Page are not found:");
    }

    @AfterClass
    public void completeNominationProcess() {
        new NominationConfirmationPage().completeNominationProcess();
        new HeaderBlock().signOut();
    }
}
