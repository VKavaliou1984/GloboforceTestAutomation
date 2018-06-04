package com.epam.tat.webdriver.pages.iaf.configapp;

import com.epam.tat.webdriver.pages.iaf.IAFMainPage;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.Link;

import static com.epam.tat.webdriver.service.Waiters.waitElementClickable;

public class ConfigAppMainPage extends IAFMainPage {

    @Name("5021 Choose Client Link")
    @FindBy(xpath = "//a[contains(@href,'5021')]")
    private Link testClient5021ChooseLink;

    public ClientConfigurationMainPage clickChooseClientButton() {
        waitElementClickable(driver, testClient5021ChooseLink).click();
        return new ClientConfigurationMainPage();
    }
}
