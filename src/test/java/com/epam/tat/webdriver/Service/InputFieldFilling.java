package com.epam.tat.webdriver.Service;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static com.epam.tat.webdriver.Service.Waiters.waitElementDisplayed;

public class InputFieldFilling {
    public static void fillInputField(WebDriver driver, By by, String value) {
        waitElementDisplayed(driver, by).clear();
        waitElementDisplayed(driver, by).sendKeys(value);
    }
}

