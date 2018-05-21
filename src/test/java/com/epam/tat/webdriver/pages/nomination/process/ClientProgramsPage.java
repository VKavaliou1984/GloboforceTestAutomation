package com.epam.tat.webdriver.pages.nomination.process;

import com.epam.tat.webdriver.pages.NominationPage;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.Button;

import static com.epam.tat.webdriver.service.Waiters.waitElementClickable;

public class ClientProgramsPage extends NominationPage {

    @Name("Default program button")
    @FindBy(xpath = "//div[contains(@class,'np-award-program-default')]")
    private Button defaultAwardProgramButton;

    public AwardReasonsPage chooseDefaultProgram() {
        waitElementClickable(driver, defaultAwardProgramButton).click();
        return new AwardReasonsPage();
    }
}
