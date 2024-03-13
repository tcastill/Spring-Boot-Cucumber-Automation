package com.automation.example.hybrid.api;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

@Slf4j
@Component
public class DatamuseApi {

    @Value("${rhymes.url}")
    private String rhymesUrl;

    public Response rhymesLike(String word){
        Response resp =
                given().contentType("application/json").
                        header("x-cd-mode", "ALL").
                        when().
                        get(rhymesUrl);

        log.info("GET Request URL is " + rhymesUrl + " with status code of " + resp.getStatusCode());
        log.debug("Response: {}", resp);
        return resp;
    }
}
