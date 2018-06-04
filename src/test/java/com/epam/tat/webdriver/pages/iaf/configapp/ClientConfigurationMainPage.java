package com.epam.tat.webdriver.pages.iaf.configapp;

import com.epam.tat.webdriver.pages.iaf.IAFMainPage;
import com.epam.tat.webdriver.pages.iaf.configapp.awards.awardprograms.AwardProgramsPage;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.Link;

import static com.epam.tat.webdriver.service.Waiters.waitElementClickable;

public class ClientConfigurationMainPage extends IAFMainPage {

    @Name("Awards Link")
    @FindBy(xpath = "//td/span[contains(text(), 'Awards')]")
    private Link awardsLink;

    @Name("Award Programs Link")
    @FindBy(xpath = "//a[contains(text(), 'Award Programs')]")
    private Link awardProgramsLink;

    public ClientConfigurationMainPage clickAwardsButton() {
        waitElementClickable(driver, awardsLink).click();
        return this;
    }

    public AwardProgramsPage clickAwardProgramsButton() {
        waitElementClickable(driver, awardProgramsLink).click();
        return new AwardProgramsPage();
    }
}
