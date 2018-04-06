package com.epam.tat.webdriver.pages;

import com.epam.tat.webdriver.Service.InputFieldFilling;
import org.openqa.selenium.By;

import static com.epam.tat.webdriver.Service.Waiters.waitElementClickable;

public class LoginPage extends BasePage {

    public LoginPage open(String URL, String server, String clientName) {
        driver.navigate().to(String.format(URL, server, clientName));
        return this;
    }

    private By userNameInputBy = By.name("username");
    private By passwordInputBy = By.name("password");
    private By signInButtonBy = By.id("signIn-button");

    public LoginPage enterUserName(String userName) {
        InputFieldFilling.fillInputField(driver, userNameInputBy, userName);
        return this;
    }

    public LoginPage enterPassword(String password) {
        InputFieldFilling.fillInputField(driver, passwordInputBy, password);
        return this;
    }

    public LandingPage clickSignIn() {
        waitElementClickable(driver, signInButtonBy).click();
        return new LandingPage();
    }
}
