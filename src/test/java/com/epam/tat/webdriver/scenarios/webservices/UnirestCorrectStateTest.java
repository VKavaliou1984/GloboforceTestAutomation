package com.epam.tat.webdriver.scenarios.webservices;

import com.epam.tat.webdriver.service.webservices.UnirestGetResponse;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UnirestCorrectStateTest extends WebServicesBaseTest {

    private static final String VALID_STATE = "NY";

    @Test
    public void checkCorrectState() throws UnirestException {
        HttpResponse<JsonNode> jsonResponse = new UnirestGetResponse().getResponse(URL, COUNTRY, VALID_STATE);
        logger.info("Response status is: " + jsonResponse.getStatus());
        Assert.assertEquals(jsonResponse.getStatus(), 200);
        logger.info("Json Response Body: " + "\n\t" + jsonResponse.getBody().getObject().toString());
        Assert.assertEquals(jsonResponse.getBody()
                .getObject()
                .getJSONObject("RestResponse")
                .getJSONObject("result")
                .get("capital"), "Albany");
    }
}
