package com.epam.tat.webdriver.scenarios.webservices;

import com.jayway.restassured.RestAssured;
import org.testng.annotations.Test;

import static org.hamcrest.core.IsEqual.equalTo;

public class RestAssuredCorrectStateTest extends WebServicesBaseTest {

    private static final String VALID_STATE = "NY";

    @Test
    public void checkCorrectState() {
        RestAssured.given().when().get(String.format(URL, COUNTRY, VALID_STATE)).then().
                statusCode(200).assertThat().body("RestResponse.result.capital", equalTo("Albany"));
    }
}
