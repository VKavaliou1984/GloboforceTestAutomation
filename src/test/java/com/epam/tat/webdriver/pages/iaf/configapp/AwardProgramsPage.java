package com.epam.tat.webdriver.pages.iaf.configapp;

import com.epam.tat.webdriver.pages.BasePage;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.element.Link;

import java.util.List;

public class AwardProgramsPage extends BasePage {

    @Name("Default Program Link")
    @FindBy(xpath = "//a[contains(@href,'clientProgramId=19976')]")
    private Link defaultAwardProgramLink;

    @Name("Service Anniversaries Program Link")
    @FindBy(xpath = "//a[contains(@href,'clientProgramId=19975')]")
    private Link serviceAnniversariesProgramLink;

    @Name("Award program Table Row")
    @FindBy(xpath = "//tr[contains(@id,'yui')]")
    private List<HtmlElement> awardProgramsTableRows;

    @Name("Award program Column Cells")
    @FindBy(xpath = "//tr[contains(@id, 'yui')]/*[contains(@class, 'program')]")
    private List<HtmlElement> awardProgramsTableColumnCells;

    @Name("Award program Column Values")
    @FindBy(xpath = "//tr[contains(@id, 'yui')]//a[contains(@href,'ProgramId')]")
    private List<HtmlElement> awardProgramsTableColumnValues;

    //tr[contains(@id, 'yui')]//a[contains(@href,'ProgramId=19976')]

    //tr[contains(@id, 'yui')]//a[contains(@href,'ProgramId')]
//    public List getAwardProgramsTableRows() {
//        for (WebElement element : awardProgramsTableRows) {
//            element.
//
//            if (element.findElement(By.xpath("//tr[contains(@id, 'yui')]//a[contains(@href,'ProgramId')]")).getAttribute("innerText").equals("testclient5021 program")) {
//                new Actions(driver).dragAndDrop(element, serviceAnniversariesProgramLink.getWrappedElement()).build().perform();
//                break;
//            }
//        }
//        return this;
//    }

//tr[contains(@id,'yui')]

    //tr[contains(@class,'yui-dt-even')]


//    public AwardProgramsPage swapAwardPrograms() {
//        new Actions(driver).dragAndDrop(defaultAwardProgramLink.getWrappedElement(),serviceAnniversariesProgramLink.getWrappedElement()).build().perform();
//        return this;
//    }

    public AwardProgramsPage swapAwardPrograms() {

        new Actions(driver).dragAndDrop(defaultAwardProgramLink.getWrappedElement(), serviceAnniversariesProgramLink.getWrappedElement()).build().perform();
        return this;
    }
}
