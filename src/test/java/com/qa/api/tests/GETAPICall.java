package com.qa.api.tests;

import basetest.BaseTest;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.microsoft.playwright.APIRequest;
import com.microsoft.playwright.APIRequestContext;
import com.microsoft.playwright.APIResponse;
import com.microsoft.playwright.Playwright;
import org.testng.annotations.Test;

import java.io.IOException;

public class GETAPICall extends BaseTest {
    @Test
    public void getUsersApitest(){

        response = requestContext.get("https://gorest.co.in/public/v2/users");
        System.out.println(response.text() +" | "+ response.statusText());

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            JsonNode node = objectMapper.readTree(response.body());
            String json = node.toPrettyString();
            System.out.println(json);
            System.out.println("Header" + response.headers());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
