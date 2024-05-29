package com.qa.api.tests;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.microsoft.playwright.APIRequest;
import com.microsoft.playwright.APIRequestContext;
import com.microsoft.playwright.APIResponse;
import com.microsoft.playwright.Playwright;
import org.testng.annotations.Test;

import java.io.IOException;

public class GETAPICall {
    @Test
    public void getUsersApitest(){
        Playwright playwright = Playwright.create();
        APIRequest apiRequest = playwright.request();
        APIRequestContext requestContext = apiRequest.newContext();

        APIResponse response = requestContext.get("https://gorest.co.in/public/v2/users");
        System.out.println(response.text() +" | "+ response.statusText());

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            JsonNode node = objectMapper.readTree(response.body());
            String json = node.toPrettyString();
            System.out.println(json);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
