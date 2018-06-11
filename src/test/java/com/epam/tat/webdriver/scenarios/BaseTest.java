package com.epam.tat.webdriver.scenarios;

import com.epam.tat.webdriver.utilities.driver.WebDriverInitializator;
import org.openqa.selenium.Platform;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.net.MalformedURLException;

import static com.epam.tat.webdriver.utilities.driver.WebDriverInitializator.LOCAL;
import static org.openqa.selenium.remote.BrowserType.CHROME;

public abstract class BaseTest {

    @BeforeTest
    @Parameters({"browser", "platform", "driverType"})
    public void initializeDriver(@Optional(CHROME) String browser, @Optional("WINDOWS") Platform platform, @Optional(LOCAL) String driverType) throws MalformedURLException {
        System.out.println("Browser in use: ".concat(browser));
        WebDriverInitializator.getInstance().setPlatform(platform);
        WebDriverInitializator.getInstance().startDriver(browser, driverType);
    }

    @AfterTest(alwaysRun = true)
    public void closeDriver() {
        WebDriverInitializator.getInstance().quitDriver();
    }
}
