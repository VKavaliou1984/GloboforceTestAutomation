package com.epam.tat.webdriver.pages;

import com.epam.tat.webdriver.utilities.driver.WebDriverInitializator;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import ru.yandex.qatools.htmlelements.loader.HtmlElementLoader;

public abstract class BasePage {

    protected WebDriver driver;
    protected Logger logger = Logger.getLogger(getClass());

    public BasePage() {
        driver = WebDriverInitializator.getInstance().getDriver();
        HtmlElementLoader.populatePageObject(this, driver);
    }
}
