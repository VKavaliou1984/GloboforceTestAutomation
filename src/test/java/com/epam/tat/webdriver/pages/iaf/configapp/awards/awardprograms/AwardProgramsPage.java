package com.epam.tat.webdriver.pages.iaf.configapp.awards.awardprograms;

import com.epam.tat.webdriver.pages.iaf.IAFMainPage;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.Link;

import java.util.List;

import static com.epam.tat.webdriver.utilities.Waiters.waitElementClickable;

public class AwardProgramsPage extends IAFMainPage {

    @Name("Award Levels Mappping Dialog Window (Add/Remove/Sort link)")
    @FindBy(xpath = "//a[contains(@href,'showAwardTypesDialog')]")
    private List<Link> programAwardLevelsLinks;

    public AwardTypesDialogPage clickAwardTypesDialog(String awardProgramName) {
        logger.info("Calling award levels mapping dialog window");
        for (Link awardLevelsLinkForDefinedProgram : programAwardLevelsLinks) {
            if (awardLevelsLinkForDefinedProgram.getWrappedElement().getAttribute("href").contains(awardProgramName)) {
                waitElementClickable(driver, awardLevelsLinkForDefinedProgram).click();
            }
        }
        return new AwardTypesDialogPage();
    }
}
