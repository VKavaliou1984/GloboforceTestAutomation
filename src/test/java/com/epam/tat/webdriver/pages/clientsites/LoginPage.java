package com.epam.tat.webdriver.pages.clientsites;

import com.epam.tat.webdriver.pages.BasePage;
import com.epam.tat.webdriver.utilities.InputFieldFilling;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.TextInput;

import static com.epam.tat.webdriver.utilities.Waiters.waitElementClickable;

public class LoginPage extends BasePage {

    private static final String URL = "https://%s/microsites/t/home?client=%s";

    @Name("Login input field")
    @FindBy(name = "username")
    private TextInput userNameInput;

    @Name("Password input field")
    @FindBy(name = "password")
    private TextInput passwordInput;

    @Name("Sign in button")
    @FindBy(id = "signIn-button")
    private Button signInButton;

    public LoginPage open(String server, String clientName) {
        driver.
                navigate().
                to(String.format(URL, server, clientName));
        return this;
    }

    public LoginPage enterUserName(String userName) {
        InputFieldFilling.fillInputField(driver, userNameInput, userName);
        return this;
    }

    public LoginPage enterPassword(String password) {
        InputFieldFilling.fillInputField(driver, passwordInput, password);
        return this;
    }

    public LandingPage clickSignIn() {
        waitElementClickable(driver, signInButton).click();
        return new LandingPage();
    }

}
