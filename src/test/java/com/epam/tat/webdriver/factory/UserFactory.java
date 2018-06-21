package com.epam.tat.webdriver.factory;

import com.epam.tat.webdriver.bo.UserBO;

public class UserFactory {

    public UserBO getIafUser() {
        return new UserBO
                .Builder("bhkb.jshcw@gqfozpkzgb.kbk", "password1", "staging-sandbox0.corp.globoforce.com")
                .build();
    }

    public UserBO get5015User() {
        return new UserBO
                .Builder("adam_admin", "password1", "staging-web1.corp.globoforce.com").enterClientName("testclient5015")
                .build();
    }
}
