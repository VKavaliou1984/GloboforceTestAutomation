package com.epam.tat.webdriver.service;

import com.epam.tat.webdriver.bo.NominationBO;
import com.epam.tat.webdriver.pages.clientsites.LandingPage;
import com.epam.tat.webdriver.pages.clientsites.nomination.NominationConfirmationPage;

public class NominationService {

    public static NominationConfirmationPage createNomination(NominationBO nomination) {
        new LandingPage().clickRecognizeButton()
                .searchRecipient(nomination.getRecipient())
                .clickNext()
                .chooseDefaultProgram()
                .chooseAwardReason()
                .chooseAwardLevel()
                .fillAwardTitle(nomination.getTitle())
                .fillAwardMessage(nomination.getMessage())
                .fillAwardApprovalMessage(nomination.getMessageForApprover())
                .submitNomination();
        return new NominationConfirmationPage();
    }
}
