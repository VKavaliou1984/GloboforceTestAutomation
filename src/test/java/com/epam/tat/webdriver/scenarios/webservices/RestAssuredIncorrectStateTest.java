package com.epam.tat.webdriver.scenarios.webservices;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.core.StringContains.containsString;

public class RestAssuredIncorrectStateTest extends WebServicesBaseTest {

    private static final String INVALID_STATE = "ZZ";

    @Test
    public void checkInCorrectState() {
        Response response = RestAssured.given().when().get(String.format(URL, COUNTRY, INVALID_STATE)).then().extract().response();
//        Assert.assertEquals();
        RestAssured.given().when().get(String.format(URL, COUNTRY, INVALID_STATE)).then().
                statusCode(200).assertThat().body(containsString("No matching state found for requested code" +
                COUNTRY + "->" + INVALID_STATE + "].]"));
    }
}
