package com.epam.tat.webdriver.service.iaf;

import com.epam.tat.webdriver.bo.UserBO;
import com.epam.tat.webdriver.pages.iaf.IAFLoginPage;
import com.epam.tat.webdriver.pages.iaf.IAFMainPage;

public class LoginIafService {

    public static IAFMainPage loginIaf(UserBO user) {
        new IAFLoginPage().
                openIAFLoginPage(user.getServer())
                .enterUserName(user.getUserName())
                .enterPassword(user.getPassword())
                .clickIAFSignIn();
        return new IAFMainPage();
    }
}
