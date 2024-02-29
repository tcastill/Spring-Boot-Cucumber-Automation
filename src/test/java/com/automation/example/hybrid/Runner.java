package com.automation.example.hybrid;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@CucumberOptions(
        features = "classpath:features",
        plugin = {
                "pretty",
                "html:target/cucumber.html",
                "json:target/cucumber.json"}
)

@RunWith(Cucumber.class)
public class Runner {
}