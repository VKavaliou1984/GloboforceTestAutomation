package com.epam.tat.webdriver.pages.clientsite;

import com.epam.tat.webdriver.pages.BasePage;
import com.epam.tat.webdriver.pages.clientsite.nomination.RecipientSelectPage;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.HtmlElement;

import static com.epam.tat.webdriver.utilities.Waiters.waitElementClickable;
import static com.epam.tat.webdriver.utilities.Waiters.waitElementDisplayed;

public class LandingPage extends BasePage {

    @Name("Recognize Button")
    @FindBy(id = "giveAward")
    private Button recognizeButton;

    @Name("In page nomination Layer (pop-up)")
    @FindBy(id = "np_mainSelectRecipients")
    private HtmlElement inPageNominationLayer;

    public RecipientSelectPage clickRecognizeButton() {
        waitElementClickable(driver, recognizeButton).click();
        waitElementDisplayed(driver, inPageNominationLayer);
        return new RecipientSelectPage();
    }
}
