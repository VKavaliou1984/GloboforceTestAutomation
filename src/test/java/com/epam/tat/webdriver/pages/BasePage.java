package com.epam.tat.webdriver.pages;

import com.epam.tat.webdriver.utilities.driver.WebDriverInitializator;
import org.openqa.selenium.WebDriver;
import ru.yandex.qatools.htmlelements.loader.HtmlElementLoader;

public abstract class BasePage {

    protected WebDriver driver;

    public BasePage() {
        driver = WebDriverInitializator.getInstance().getDriver();
        HtmlElementLoader.populatePageObject(this, driver);
    }
}
