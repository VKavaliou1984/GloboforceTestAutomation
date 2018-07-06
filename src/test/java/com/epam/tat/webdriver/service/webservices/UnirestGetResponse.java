package com.epam.tat.webdriver.service.webservices;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

public class UnirestGetResponse {

    public HttpResponse<JsonNode> getResponse(String url, String country, String state) throws UnirestException {
        HttpResponse<JsonNode> jsonResponse = Unirest.get(String.format(url, country, state))
                .asJson();
        return jsonResponse;
    }
}
