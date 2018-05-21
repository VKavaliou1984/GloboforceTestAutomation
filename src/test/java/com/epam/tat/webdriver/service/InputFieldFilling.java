package com.epam.tat.webdriver.service;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static com.epam.tat.webdriver.service.Waiters.waitElementDisplayed;

public class InputFieldFilling {
    public static void fillInputField(WebDriver driver, WebElement webElement, String value) {
        waitElementDisplayed(driver, webElement).clear();
        waitElementDisplayed(driver, webElement).sendKeys(value);
    }
}

