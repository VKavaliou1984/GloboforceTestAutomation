package com.epam.tat.webdriver.scenarios;

import com.epam.tat.webdriver.service.driver.WebDriverInitializator;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import static org.openqa.selenium.remote.BrowserType.*;

public abstract class BaseTest {

    protected static final String CLIENT_NAME = "testclient5015";
    protected static final String USER_NAME = "adam_admin";
    protected static final String PASSWORD = "password1";
    protected static final String SERVER = "staging-web1.corp.globoforce.com"; //"psupport-web1.corp.globoforce.com"; //preprod-sandbox0.corp.globoforce.com //sandbox0.globoforce.com //psupport-sandbox0.corp.globoforce.com //psupport-web1.corp.globoforce.com

    @BeforeClass
    @Parameters({"browser"})
    public void initializeDriver(@Optional(FIREFOX) String browser) {
        System.out.println("Browser in use: ".concat(browser));
        WebDriverInitializator.
                getInstance().
                startDriver(browser);
    }
}
