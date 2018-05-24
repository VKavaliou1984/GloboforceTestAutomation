package com.epam.tat.webdriver.scenarios;

import com.epam.tat.webdriver.service.driver.WebDriverInitializator;
import org.openqa.selenium.Platform;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.net.MalformedURLException;

import static org.openqa.selenium.remote.BrowserType.CHROME;

public abstract class BaseTest {

    protected static final String CLIENT_NAME = "testclient5015";
    protected static final String USER_NAME = "adam_admin";
    protected static final String PASSWORD = "password1";
    protected static final String SERVER = "staging-web1.corp.globoforce.com"; //"psupport-web1.corp.globoforce.com"; //preprod-sandbox0.corp.globoforce.com //sandbox0.globoforce.com //psupport-sandbox0.corp.globoforce.com //psupport-web1.corp.globoforce.com

    @BeforeTest
    @Parameters({"browser", "platform", "driverType"})
    public void initializeDriver(@Optional(CHROME) String browser, @Optional("WINDOWS") Platform platform, @Optional("local") String driverType) throws MalformedURLException {
        System.out.println("Browser in use: ".concat(browser));
        WebDriverInitializator.getInstance().setPlatform(platform);
        WebDriverInitializator.getInstance().startDriver(browser, driverType);
    }

    @AfterTest(alwaysRun = true)
    public void closeDriver() {
        WebDriverInitializator.getInstance().quitDriver();
    }
}
