package com.epam.tat.webdriver.pages.clientsites.nomination;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.HtmlElement;

import java.util.List;

import static com.epam.tat.webdriver.utilities.Waiters.waitElementClickable;
import static com.epam.tat.webdriver.utilities.Waiters.waitElementDisplayed;

public class AwardLevelsPage extends NominationPage {

    @Name("Award level button")
    @FindBy(xpath = "//div[contains(@class,'np-award-value-wrapper')]")
    private Button awardLevelsButton;

    @Name("Award level button array")
    @FindBy(xpath = "//div[contains(@class,'np-award-value-wrapper')]//bdi")
    private List<HtmlElement> awardLevelsButtons;

    public AwardDetailsPage chooseAwardLevel(String awardLevel) {
        waitElementDisplayed(driver, awardLevelsButton);
        for (WebElement element : awardLevelsButtons) {
            if (element.getText().contains(awardLevel)) {
                waitElementClickable(driver, element).click();
                break;
            }
        }
        return new AwardDetailsPage();
    }
}
