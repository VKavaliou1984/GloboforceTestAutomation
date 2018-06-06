package com.epam.tat.webdriver.scenarios;

import com.epam.tat.webdriver.utilities.driver.WebDriverInitializator;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

public class RemoteDriverTest extends BaseTest {

    @Test
    public void startRemoteDriverTest() throws MalformedURLException {
        WebDriverInitializator.getInstance().getDriver().get("https://www.globoforce.com/");
        Assert.assertEquals(WebDriverInitializator.getInstance().getDriver().getTitle(), "Globoforce | Elevate Workplace Culture and Performance | Globoforce");
        System.out.println("test");
    }
}
