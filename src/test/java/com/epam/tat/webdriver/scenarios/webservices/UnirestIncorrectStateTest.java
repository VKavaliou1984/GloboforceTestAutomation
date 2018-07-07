package com.epam.tat.webdriver.scenarios.webservices;

import com.epam.tat.webdriver.service.webservices.UnirestGetResponse;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.testng.annotations.Test;

public class UnirestIncorrectStateTest extends WebServicesBaseTest {

    private static final String INVALID_STATE = "ZZ";

    @Test
    public void checkIncorrectState() throws UnirestException {
        HttpResponse<JsonNode> jsonResponse = new UnirestGetResponse().getResponse(URL, COUNTRY, INVALID_STATE);
        logger.info("Response status is: " + jsonResponse.getStatus());
        softAssert.assertEquals(jsonResponse.getStatus(), 200);
        logger.info("Json Response Body: " + "\n\t" + jsonResponse.getBody());
        softAssert.assertEquals(jsonResponse.getBody().toString(),
                "{\"RestResponse\":{\"messages\":[\"No matching state found for requested code ["
                        + COUNTRY + "->" + INVALID_STATE + "].\"]}}");
        softAssert.assertAll();
    }
}
