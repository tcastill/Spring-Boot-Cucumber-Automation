package com.automation.example.hybrid.stepDefs;

import com.automation.example.hybrid.annotations.LazyAutowired;
import io.cucumber.java.After;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.springframework.context.ApplicationContext;

@Slf4j
public class CucumberHooks {

    @LazyAutowired
    private ApplicationContext applicationContext;

    @After
    public void afterScenario() {
        log.info("Closing the browser");
        try{
            this.applicationContext.getBean(WebDriver.class).quit();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
