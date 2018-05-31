package com.epam.tat.webdriver.pages.iaf.configapp.awards.awardprograms;

import com.epam.tat.webdriver.pages.iaf.IAFMainPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.HtmlElement;

import java.util.List;

import static com.epam.tat.webdriver.service.Waiters.waitElementClickable;

public class AwardTypesDialogPage extends IAFMainPage {

    @Name("Unmapped Award Levels")
    @FindBy(xpath = "//li[contains(@id,'true')]")
    private List<WebElement> unmappedAwardLevels;

    @Name("Mapped Award Levels")
    @FindBy(xpath = "//li[contains(@id,'false')]")
    private List<HtmlElement> mappedAwardLevels;

    @Name("Award Levels Mapped To The Award Program (Drag List")
    @FindBy(id = "all_items")
    private HtmlElement ummappedAwardLevelDragList;

    @Name("Save Award Mapping Changes Button")
    @FindBy(id = "save-button")
    private HtmlElement savingAwardMappingChangesButton;


    public HtmlElement findAwardLevel(String awardName) {
        HtmlElement targetAward = null;
        for (HtmlElement mappedAwardLevel : mappedAwardLevels) {
            if (mappedAwardLevel.getWrappedElement().getText().contains(awardName)) {
                targetAward = mappedAwardLevel;
                break;
            }
        }
        return targetAward;
    }

    public AwardTypesDialogPage unmapAwardFromProgram(String awardName) {
        new Actions(driver).dragAndDrop(findAwardLevel(awardName).getWrappedElement(), ummappedAwardLevelDragList.getWrappedElement()).build().perform();
        return new AwardTypesDialogPage();
    }

    public void saveAwardMapping() {
        waitElementClickable(driver, savingAwardMappingChangesButton).click();
    }
}
