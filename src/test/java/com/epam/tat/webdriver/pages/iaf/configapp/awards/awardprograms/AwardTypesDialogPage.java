package com.epam.tat.webdriver.pages.iaf.configapp.awards.awardprograms;

import com.epam.tat.webdriver.pages.iaf.IAFMainPage;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.HtmlElement;

import java.util.List;

import static com.epam.tat.webdriver.utilities.ActionsUtil.dragAndDrop;
import static com.epam.tat.webdriver.utilities.Waiters.*;

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

    public HtmlElement findAwardLevel(String awardName, Boolean getMappedAwardLevels) {
        HtmlElement targetAward = null;
        List<HtmlElement> awardList = null;
        if (getMappedAwardLevels) {
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
        waitElementDisplayed(driver, unmappedAwardLevelsDragList);
        dragAndDrop(driver, findAwardLevel(awardName, true).getWrappedElement(),
                unmappedAwardLevelsDragList.getWrappedElement());
        return this;
    }

    public AwardTypesDialogPage mapAwardToProgram(String awardName) {
        waitElementDisplayed(driver, mappedAwardLevelsDragList);
        dragAndDrop(driver, findAwardLevel(awardName, false).getWrappedElement(),
                mappedAwardLevelsDragList.getWrappedElement());
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
