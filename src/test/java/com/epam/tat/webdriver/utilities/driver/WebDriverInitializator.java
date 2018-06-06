package com.epam.tat.webdriver.utilities.driver;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.remote.BrowserType.*;

public class WebDriverInitializator {

    private WebDriver driver;
    private static final int IMPLICIT_TIMEOUT = 5;
    private static WebDriverInitializator webDriverInitializator = null;
    private Platform platform;
    public static final String LOCAL = "local";
    public static final String REMOTE = "remote";

    public static WebDriverInitializator getInstance() {
        if (webDriverInitializator == null) {
            webDriverInitializator = new WebDriverInitializator();
        }
        return webDriverInitializator;
    }

    public Platform getPlatform() {
        return platform;
    }

    public void setPlatform(Platform platform) {
        this.platform = platform;
    }

    public WebDriver getDriver() {
        return driver;
    }

    private WebDriver launchChromeDriver() {
        System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\driver\\chromedriver.exe");
        driver = new ChromeDriver();
        setDriverSettings(driver);
        return driver;
    }

    private WebDriver launchFirefoxDriver() {
        System.setProperty("webdriver.gecko.driver", "src\\test\\resources\\driver\\geckodriver.exe");
        driver = new FirefoxDriver();
        setDriverSettings(driver);
        return driver;
    }

    private WebDriver launchEdgeDriver() {
        System.setProperty("webdriver.edge.driver", "src\\test\\resources\\driver\\MicrosoftWebDriver.exe");
        driver = new EdgeDriver();
        setDriverSettings(driver);
        return driver;
    }

    private void setDriverSettings(WebDriver driver) {
        driver.manage().timeouts().implicitlyWait(IMPLICIT_TIMEOUT, TimeUnit.SECONDS);
        driver.manage().window().setSize(new Dimension(1920, 1080));
    }

    public WebDriver startDriver(String browserType, String driverType) throws MalformedURLException {
        if (driverType.equals(LOCAL)) {
            switch (browserType) {
                case CHROME:
                    launchChromeDriver();
                    break;
                case FIREFOX:
                    launchFirefoxDriver();
                    break;
                case EDGE:
                    launchEdgeDriver();
                    break;
            }
        } else if (driverType.equals(REMOTE)) {
            startRemoteDriver(browserType, driverType);
        }
        return driver;
    }

    public void quitDriver() {
        if (driver != null)
            driver.quit();
        driver = null;
    }

    public WebDriver startRemoteDriver(String browserType, String driverType) throws MalformedURLException {
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setBrowserName(browserType);
        cap.setPlatform(getPlatform());
        URL url = new URL("http://192.168.56.1:4444/wd/hub");
        driver = new RemoteWebDriver(url, cap);
        return driver;
    }
}
