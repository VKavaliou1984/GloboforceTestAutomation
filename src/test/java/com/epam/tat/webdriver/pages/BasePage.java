package com.epam.tat.webdriver.pages;

import com.epam.tat.webdriver.Service.Driver.WebDriverInitializator;
import org.openqa.selenium.WebDriver;

public abstract class BasePage {

    protected WebDriver driver = WebDriverInitializator.getInstance().getDriver();
}
