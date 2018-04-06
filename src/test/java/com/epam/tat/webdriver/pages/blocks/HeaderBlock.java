package com.epam.tat.webdriver.pages.blocks;

import com.epam.tat.webdriver.pages.BasePage;
import com.epam.tat.webdriver.pages.LogOutPage;
import org.openqa.selenium.By;

import static com.epam.tat.webdriver.Service.Waiters.waitElementClickable;

public class HeaderBlock extends BasePage {

    private By signOutButton = By.xpath("//a[contains(@href,'logout')]");

    public LogOutPage clickSignOut() {
        waitElementClickable(driver, signOutButton).click();
        return new LogOutPage();
    }
}
