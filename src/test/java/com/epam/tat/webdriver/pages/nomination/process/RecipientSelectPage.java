package com.epam.tat.webdriver.pages.nomination.process;

import com.epam.tat.webdriver.Service.InputFieldFilling;
import com.epam.tat.webdriver.pages.Nomination;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static com.epam.tat.webdriver.Service.Waiters.waitElementClickable;
import static com.epam.tat.webdriver.Service.Waiters.waitElementDisplayed;

public class RecipientSelectPage extends Nomination {

    private By searchRecipientFieldBy = By.id("np-recipient-search-field");
    private By chooseRecipientButtonBy = By.cssSelector(".np-recipient-action");
    private By nextButtonBy = By.xpath("//button[contains(@class,'js-np-next')]");

    public RecipientSelectPage searchRecipient(String recipient) {
        InputFieldFilling.fillInputField(driver, searchRecipientFieldBy, recipient);
        waitElementDisplayed(driver, By.xpath("//p[contains(@class,'np-recipient-list-name')]"));
        List<WebElement> chooseRecipientButtons = driver.findElements(chooseRecipientButtonBy);
        for (WebElement element : chooseRecipientButtons) {
            if (element.findElement(By.xpath("//preceding::h4")).getAttribute("innerText").equals(recipient)) {
                element.click();
                break;
            }
        }
        return this;
    }

    public ClientProgramsPage clickNext() {
        waitElementClickable(driver, nextButtonBy).click();
        return new ClientProgramsPage();
    }
}