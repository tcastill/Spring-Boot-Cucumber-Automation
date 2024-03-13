package com.automation.example.hybrid.stepDefs;

import com.automation.example.hybrid.annotations.LazyAutowired;
import com.automation.example.hybrid.api.DatamuseApi;
import com.automation.example.hybrid.pages.Base;
import com.automation.example.hybrid.repository.DictionaryRepository;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ApiDefs extends Base{

    @LazyAutowired
    private DatamuseApi api;

    @LazyAutowired
    private DictionaryRepository repository;

    private Response resp;

    @Given("sounds like api returns a 200 for word {string}")
    public void soundsLikeApiReturnsAForWord(String word) {
        resp = api.rhymesLike(word);
        assertEquals(resp.statusCode(), 200);
    }

    @Then("check that one of the words is {string}")
    public void checkThatOneOfTheWordsIs(String word) {
        addLog("Assertions", resp.body().prettyPrint());
        assertTrue(resp.body().asString().contains(word));
    }
}
    
    
