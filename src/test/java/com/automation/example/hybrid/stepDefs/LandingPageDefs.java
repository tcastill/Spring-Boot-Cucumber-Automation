package com.automation.example.hybrid.stepDefs;

import com.automation.example.hybrid.annotations.LazyAutowired;
import com.automation.example.hybrid.pages.LandingPage;
import com.automation.example.hybrid.repository.DictionaryRepository;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class LandingPageDefs {

    @LazyAutowired
    private LandingPage page;

    @LazyAutowired
    private DictionaryRepository repository;

    @Given("user is able to validate the page visibly as correct")
    public void userIsAbleToValidateThePageVisiblyAsCorrect() {
        this.page.goTo();
    }

    @Then("all the links on the page directs correctly")
    public void allTheLinksOnThePageDirectsCorrectly() {
        this.repository.findById("best").ifPresent(
                test -> {
                    System.out.println(test.getResult());
                }
        );
    }
}
