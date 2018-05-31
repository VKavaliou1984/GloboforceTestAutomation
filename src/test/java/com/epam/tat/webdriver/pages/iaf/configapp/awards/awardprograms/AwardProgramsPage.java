package com.epam.tat.webdriver.pages.iaf.configapp.awards.awardprograms;

import com.epam.tat.webdriver.pages.iaf.IAFMainPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.element.Link;

import java.util.List;

import static com.epam.tat.webdriver.service.Waiters.waitElementClickable;

public class AwardProgramsPage extends IAFMainPage {

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
    @FindBy(xpath = "//tbody[contains(@class,'yui-dt-data')]")
    private List<HtmlElement> awardProgramsTableColumnValues;

    @Name("Award Levels Mappping Dialog Window (Add/Remove/Sort link)")
    @FindBy(xpath = "//a[contains(@href,'showAwardTypesDialog')]")
    private Link programAwardLevelsLink;

    WebElement allRows = driver.findElement(By.xpath("//tbody[contains(@class,'yui-dt-data')]"));

    public AwardTypesDialogPage clickAwardTypesDialog() {

        waitElementClickable(driver, programAwardLevelsLink).click();
        return new AwardTypesDialogPage();
    }

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


//    private WebElement getAwardProgramLine(String awardProgramNameText) {
//        WebElement targetAwardProgramLine = null;
//        for (HtmlElement awardProgramLine : awardProgramsTableRows) {
//            WebElement awardProgramName = awardProgramLine.findElement(By.xpath("descendant::a[contains(@href,'ProgramId')]"));
//            if (awardProgramName.getText().equals(awardProgramNameText)) {
//                targetAwardProgramLine = awardProgramLine.getWrappedElement();
//                break;
//            }
//        }
//        return targetAwardProgramLine;
//    }
//
//    public void swapAwardPrograms() {
//        new Actions(driver).dragAndDrop(getAwardProgramLine("testclient5021 program"),allRows)
////        new Actions(driver).dragAndDropBy(getAwardProgramLine("testclient5021 program"),120 )
//                 .build().perform();
//        try {
//            Thread.sleep(10000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//
//    }
}
