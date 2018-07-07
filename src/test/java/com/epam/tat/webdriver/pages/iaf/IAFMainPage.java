package com.epam.tat.webdriver.pages.iaf;

import com.epam.tat.webdriver.pages.BasePage;
import com.epam.tat.webdriver.pages.iaf.configapp.ConfigAppMainPage;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.Link;

import static com.epam.tat.webdriver.utilities.Waiters.waitElementClickable;

public class IAFMainPage extends BasePage {

    @Name("Config App Link")
    @FindBy(xpath = "//a[@href='/iaf-config-app/']")
    private Link configAppLink;

    @Name("Other Applications Drop Down List (Link)")
    @FindBy(xpath = "//a[contains(@class,'drop')]")
    private Link otherApplicationsLink;

    @Name("IAF Sign Out Button")
    @FindBy(xpath = "//a[contains(@href,'logout')]")
    private Button iafSignOutButton;

    public ConfigAppMainPage clickConfigAppButton() {
        logger.info("Clicking Config App link");
        new Actions(driver).moveToElement(otherApplicationsLink
                .getWrappedElement())
                .moveToElement(configAppLink.getWrappedElement())
                .click()
                .build()
                .perform();
        return new ConfigAppMainPage();
    }

    public void clickSignOutButton() {
        logger.info("Clicking Sign Out button");
        waitElementClickable(driver, iafSignOutButton).click();
    }
}
