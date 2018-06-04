package com.epam.tat.webdriver.pages.clientsite.blocks;

import com.epam.tat.webdriver.pages.BasePage;
import com.epam.tat.webdriver.pages.clientsite.LogOutPage;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.Button;

import static com.epam.tat.webdriver.service.Waiters.waitElementClickable;

public class HeaderBlock extends BasePage {

    @Name("Sign Out button")
    @FindBy(xpath = "//a[contains(@href,'logout')]")
    private Button signOutButton;

    public LogOutPage signOut() {
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
