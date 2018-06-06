package com.epam.tat.webdriver.pages.clientsite.nomination;

import com.epam.tat.webdriver.utilities.InputFieldFilling;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.element.TextBlock;
import ru.yandex.qatools.htmlelements.element.TextInput;

import java.util.List;

import static com.epam.tat.webdriver.utilities.Waiters.waitElementClickable;
import static com.epam.tat.webdriver.utilities.Waiters.waitElementDisplayed;

public class RecipientSelectPage extends NominationPage {

    @Name("Search recipient field")
    @FindBy(id = "np-recipient-search-field")
    private TextInput searchRecipientField;

    @Name("Choose recipient button")
    @FindBy(css = ".np-recipient-action")
    private List<HtmlElement> chooseRecipientButtons;

    @Name("Search results for {search request} field (Information field")
    @FindBy(xpath = "//p[contains(@class,'np-recipient-list-name')]")
    private TextBlock searchResultsForInfoField;

    @Name("Recipients addition confirmation button (Next button)")
    @FindBy(xpath = "//button[contains(@class,'js-np-next')]")
    private Button nextButton;

    public RecipientSelectPage searchRecipient(String recipient) {
        InputFieldFilling.fillInputField(driver, searchRecipientField, recipient);
        waitElementDisplayed(driver, searchResultsForInfoField);
        for (WebElement element : chooseRecipientButtons) {
            if (element.findElement(By.xpath("//preceding::h4")).getAttribute("innerText").equals(recipient)) {
                element.click();
                break;
            }
        }
        return this;
    }

    public ClientProgramsPage clickNext() {
        waitElementClickable(driver, nextButton).click();
        return new ClientProgramsPage();
    }
}
