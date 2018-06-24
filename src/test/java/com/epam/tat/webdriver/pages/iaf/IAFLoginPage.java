package com.epam.tat.webdriver.pages.iaf;

import com.epam.tat.webdriver.pages.BasePage;
import com.epam.tat.webdriver.utilities.InputFieldFilling;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.TextInput;

import static com.epam.tat.webdriver.utilities.Waiters.waitElementClickable;

public class IAFLoginPage extends BasePage {

    private static final String URL = "https://%s/iaf-login-app/home";

    @Name("IAF Login input field")
    @FindBy(name = "j_username")
    private TextInput iafUserNameInput;

    @Name("Password input field")
    @FindBy(name = "j_password")
    private TextInput iafPasswordInput;

    @Name("Sign in button")
    @FindBy(xpath = "//input[@type='submit']")
    private Button iafSignInButton;

    public IAFLoginPage openIAFLoginPage(String server) {
        logger.info("Opening IAF Login page");
        driver.navigate().to(String.format(URL, server));
        return this;
    }

    public IAFLoginPage enterUserName(String userName) {
        logger.info("Filling user name");
        InputFieldFilling.fillInputField(driver, iafUserNameInput, userName);
        return this;
    }

    public IAFLoginPage enterPassword(String password) {
        logger.info("Filling password");
        InputFieldFilling.fillInputField(driver, iafPasswordInput, password);
        return this;
    }

    public IAFMainPage clickIAFSignIn() {
        logger.info("Clicking Sign In button");
        waitElementClickable(driver, iafSignInButton).click();
        return new IAFMainPage();
    }
}
