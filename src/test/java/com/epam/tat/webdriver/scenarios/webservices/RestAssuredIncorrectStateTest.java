package com.epam.tat.webdriver.scenarios.webservices;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RestAssuredIncorrectStateTest extends WebServicesBaseTest {

    private static final String INVALID_STATE = "ZZ";

    @Test
    public void checkInCorrectState() {
        Response response = RestAssured.given().when().get(String.format(URL, COUNTRY, INVALID_STATE)).then().extract().response();
        Assert.assertEquals(response.getStatusCode(), 200);
        Assert.assertTrue(response.body().asString().contains("No matching state found for requested code"));
    }
}
