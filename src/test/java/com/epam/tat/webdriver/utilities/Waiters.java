package com.epam.tat.webdriver.utilities;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Waiters {

    public static WebElement waitElementClickable(WebDriver driver, WebElement webElement) {
        return new WebDriverWait(driver, 10)
                .ignoring(StaleElementReferenceException.class)
                .pollingEvery(Duration.ofSeconds(1))
                .until(ExpectedConditions.elementToBeClickable(webElement));
    }

    public static WebElement waitElementDisplayed(WebDriver driver, WebElement webElement) {
        return new WebDriverWait(driver, 10)
                .ignoring(StaleElementReferenceException.class)
                .pollingEvery(Duration.ofSeconds(1))
                .until(ExpectedConditions.visibilityOf(webElement));
    }

    public static Boolean waitElementInvisible(WebDriver driver, WebElement webElement) {
        return new WebDriverWait(driver, 20)
                .pollingEvery(Duration.ofSeconds(1))
                .until(ExpectedConditions.invisibilityOf(webElement));
    }
}
