package com.automation.example.hybrid.pages;

import com.automation.example.hybrid.annotations.LazyAutowired;
import com.automation.example.hybrid.configuration.WebDriverWaitConfig;
import io.qameta.allure.Allure;
import java.io.ByteArrayInputStream;
import javax.annotation.PostConstruct;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class Base {
    @Autowired
    protected WebDriver driver;

    @Autowired
    protected WebDriverWaitConfig waitConfig;

    @LazyAutowired
    protected WebDriverWait wait;

    @PostConstruct
    private void init() {
        PageFactory.initElements(this.driver, this);
        driver.manage().deleteAllCookies();
        wait = waitConfig.webDriverWait(driver);
    }

    public void takeScreenshot() {
        Allure.addAttachment("Page Screenshot", new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
    }

    public void addLog(String description, String text) {
        Allure.addAttachment(description, "text/plain", text);
    }

}