package com.epam.tat.webdriver.pages.clientsite.nomination;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.HtmlElement;

import java.util.ArrayList;
import java.util.List;

import static com.epam.tat.webdriver.service.Waiters.waitElementClickable;

public class AwardReasonsPage extends NominationPage {

    @Name("Award reason button")
    @FindBy(xpath = "//div[contains(@class,'np-award-reason-item')]")
    private Button awardReasonButton;

    @Name("Award reason description button")
    @FindBy(xpath = "//div[contains(@class,'np-award-reason-description')]")
    private List<HtmlElement> awardReasonDescriptionButtons;

    public AwardLevelsPage chooseAwardReason() {
        waitElementClickable(driver, awardReasonButton).click();
        return new AwardLevelsPage();
    }

    public List<String> getAwardReasonsDescription() {
        List<String> awardReasonsDescriptionValues = new ArrayList<>();
        for (WebElement element : awardReasonDescriptionButtons) {
            awardReasonsDescriptionValues.add(StringUtils.deleteWhitespace(element.getAttribute("innerText")));
        }
        System.out.println(awardReasonsDescriptionValues.toString());
        return awardReasonsDescriptionValues;
    }
}