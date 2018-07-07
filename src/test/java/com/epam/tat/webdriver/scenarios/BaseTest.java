package com.epam.tat.webdriver.scenarios;

import com.epam.tat.webdriver.utilities.CustomListener;
import com.epam.tat.webdriver.utilities.ScreenshotsUtil;
import com.epam.tat.webdriver.utilities.driver.WebDriverInitializator;
import org.apache.log4j.Logger;
import org.openqa.selenium.Platform;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.net.MalformedURLException;

import static com.epam.tat.webdriver.utilities.driver.WebDriverInitializator.LOCAL;
import static org.openqa.selenium.remote.BrowserType.CHROME;

@Listeners(CustomListener.class)
public abstract class BaseTest {

    protected Logger logger = Logger.getLogger(getClass());

    @BeforeTest
    @Parameters({"browser", "platform", "driverType"})
    public void initializeDriver(@Optional(CHROME) String browser, @Optional("WINDOWS") Platform platform, @Optional(LOCAL) String driverType) throws MalformedURLException {
        logger.info("Initializing web driver");
        System.out.println("Browser in use: ".concat(browser));
        WebDriverInitializator.getInstance().setPlatform(platform);
        WebDriverInitializator.getInstance().startDriver(browser, driverType);
    }

    @AfterMethod
    public void takeScreenshot(ITestResult result) {
        ScreenshotsUtil.captureScreenshot(WebDriverInitializator.getInstance().getDriver(), result);
    }

    @AfterTest(alwaysRun = true)
    public void closeDriver() {
        WebDriverInitializator.getInstance().quitDriver();
    }
}
