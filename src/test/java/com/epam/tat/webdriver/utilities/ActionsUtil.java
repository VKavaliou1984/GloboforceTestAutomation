package com.epam.tat.webdriver.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ActionsUtil {

    public static void dragAndDrop(WebDriver driver, WebElement sourceElement, WebElement targetElement) {
        new Actions(driver)
                .dragAndDrop(sourceElement, targetElement)
                .build()
                .perform();
    }
}
