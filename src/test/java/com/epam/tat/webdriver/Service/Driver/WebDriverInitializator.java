package com.epam.tat.webdriver.service.driver;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class WebDriverInitializator {

    private WebDriver driver;
    private static final int IMPLICIT_TIMEOUT = 5;
    private static WebDriverInitializator webDriverInitializator = null;

    private WebDriverInitializator() {
    }

    public static WebDriverInitializator getInstance() {
        if (webDriverInitializator == null) {
            webDriverInitializator = new WebDriverInitializator();
        }
        return webDriverInitializator;
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

    public WebDriver startDriver(BrowserType type) {
        switch (type) {
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

        return driver;
    }

    public WebDriver closeDriver() {
        if (driver != null)
            driver.quit();
        return driver;
    }
}
