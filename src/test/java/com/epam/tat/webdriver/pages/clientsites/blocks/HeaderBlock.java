package com.epam.tat.webdriver.pages.clientsites.blocks;

import com.epam.tat.webdriver.pages.BasePage;
import com.epam.tat.webdriver.pages.clientsites.LogOutPage;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.Button;

import static com.epam.tat.webdriver.utilities.Waiters.waitElementClickable;

public class HeaderBlock extends BasePage {

    @Name("Sign Out button")
    @FindBy(xpath = "//a[contains(@href,'logout')]")
    private Button signOutButton;

    public LogOutPage signOut() {
        logger.info("Clicking Sign Out button");
        for (int i = 0; i < 3; i++) {
            try {
                clickSignOutButton();
            } catch (WebDriverException ignore) {
            }
        }
        return new LogOutPage();
    }

    private void clickSignOutButton() {
        waitElementClickable(driver, signOutButton).click();
    }
}
