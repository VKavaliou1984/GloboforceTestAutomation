package com.epam.tat.webdriver.service;

import com.epam.tat.webdriver.bo.UserBO;
import com.epam.tat.webdriver.pages.clientsites.LandingPage;
import com.epam.tat.webdriver.pages.clientsites.LoginPage;

public class LoginClientSiteService {

    public static LandingPage loginClientSite(UserBO user) {
        new LoginPage().
                open(user.getServer(), user.getClientName())
                .enterUserName(user.getUserName())
                .enterPassword(user.getPassword())
                .clickSignIn();
        return new LandingPage();
    }
}

