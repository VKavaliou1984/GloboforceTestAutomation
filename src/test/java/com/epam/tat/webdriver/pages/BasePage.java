package com.epam.tat.webdriver.pages;

import com.epam.tat.webdriver.service.driver.WebDriverInitializator;
import org.openqa.selenium.WebDriver;

public abstract class BasePage {

    protected WebDriver driver = WebDriverInitializator.getInstance().getDriver();
}
