package com.epam.tat.webdriver.pages.iaf.configapp.awards.awardprograms;

import com.epam.tat.webdriver.pages.iaf.IAFMainPage;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.HtmlElement;

import java.util.List;

import static com.epam.tat.webdriver.service.Waiters.*;

public class AwardTypesDialogPage extends IAFMainPage {

    @Name("Mapped Award Levels")
    @FindBy(xpath = "//*[@id='current_items']/li")
    private List<HtmlElement> mappedAwardLevels;

    @Name("Unmapped Award Levels List")
    @FindBy(xpath = "//*[@id='all_items']/li")
    private List<HtmlElement> unmappedAwardLevels;

    @Name("Unmapped Award Levels Element")
    @FindBy(id = "all_items")
    private HtmlElement unmappedAwardLevelsDragList;

    @Name("Mapped Award Levels Element")
    @FindBy(id = "current_items")
    private HtmlElement mappedAwardLevelsDragList;

    @Name("Save Award Mapping Changes Button")
    @FindBy(id = "save-button")
    private HtmlElement awardMappingSaveChangesButton;

    @Name("Progress Bar During Saving")
    @FindBy(id = "wait_c")
    private HtmlElement progressBar;

    public HtmlElement findAwardLevel(String awardName, Boolean isAwardMapped) {
        HtmlElement targetAward = null;
        List<HtmlElement> awardList = null;
        if (isAwardMapped) {
            awardList = mappedAwardLevels;
        } else awardList = unmappedAwardLevels;
        for (HtmlElement award : awardList) {
            if (award.getWrappedElement().getText().contains(awardName)) {
                targetAward = award;
                break;
            }
        }
        return targetAward;
    }

    public AwardTypesDialogPage unmapAwardFromProgram(String awardName) {
        new Actions(driver)
                .dragAndDrop(findAwardLevel(awardName, true).getWrappedElement(), unmappedAwardLevelsDragList.getWrappedElement())
                .build()
                .perform();
        return this;
    }

    public AwardTypesDialogPage mapAwardToProgram(String awardName) {
        waitElementDisplayed(driver, mappedAwardLevelsDragList);
        new Actions(driver)
                .dragAndDrop(findAwardLevel(awardName, false).getWrappedElement(),
                        mappedAwardLevelsDragList.getWrappedElement())
                .build()
                .perform();
        return this;
    }

    public AwardProgramsPage waitUntilChangesSaved() {
        waitElementDisplayed(driver, progressBar);
        waitElementInvisible(driver, progressBar);
        return new AwardProgramsPage();
    }

    public AwardTypesDialogPage saveAwardMapping() {
        waitElementClickable(driver, awardMappingSaveChangesButton).click();
        return this;
    }
}
