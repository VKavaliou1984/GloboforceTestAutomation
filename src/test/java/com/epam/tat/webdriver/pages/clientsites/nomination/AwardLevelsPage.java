package com.epam.tat.webdriver.pages.clientsites.nomination;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.HtmlElement;

import java.util.ArrayList;
import java.util.List;

import static com.epam.tat.webdriver.utilities.Waiters.waitElementClickable;

public class AwardLevelsPage extends NominationPage {

    @Name("Award level button")
    @FindBy(xpath = "//div[contains(@class,'np-award-value-wrapper')]")
    private Button awardLevelsButton;

    @Name("Award level button array")
    @FindBy(xpath = "//div[contains(@class,'np-award-value-wrapper')]")
    private List<HtmlElement> awardLevelsButtons;

    public AwardDetailsPage chooseAwardLevel() {
        waitElementClickable(driver, awardLevelsButton).click();
        return new AwardDetailsPage();
    }

//    public List<WebElement> getAwardHeaders() {
//        List<WebElement> result = driver.findElements(By.xpath("//div[contains(@class,'np-award-value-wrapper')]//bdi[contains(text(),'Award')]"));
//
//        List<String> text = new ArrayList<>();
//
//        for(WebElement element : result) {
//            text.add(element.getText());
//        }
//        return result;
//
//    }
//
//
//    public AwardDetailsPage chooseAwardLevel(String awardLevel) {
//        getAwardHeaders();
//        List<String> text2 = new ArrayList<>();
//        for (WebElement element : awardLevelsButtons) {
//            text2.add(element.findElement(By.xpath("//bdi[contains(text(),'Award')]")).getText());
//            System.out.println("Test5" + (element.findElement(By.xpath("//bdi[contains(text(),'Award')]")).getText()));
//            if (element.findElement(By.xpath("//bdi[contains(text(),'Award')]")).getText().equals(awardLevel)) {
//                waitElementClickable(driver, element).click();
//                break;
//            }
//        }
//        return new AwardDetailsPage();
//    }
}
