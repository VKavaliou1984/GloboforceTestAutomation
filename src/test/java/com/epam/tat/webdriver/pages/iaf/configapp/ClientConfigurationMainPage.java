package com.epam.tat.webdriver.pages.iaf.configapp;

import com.epam.tat.webdriver.pages.iaf.IAFMainPage;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.Link;

import static com.epam.tat.webdriver.service.Waiters.waitElementClickable;

public class ClientConfigurationMainPage extends IAFMainPage {

    @Name("Awards Link")
    @FindBy(id = "ygtvlabelel39")
    private Link awardsLink;

    @Name("Award Programs Link")
    @FindBy(id = "ygtvlabelel40")
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
