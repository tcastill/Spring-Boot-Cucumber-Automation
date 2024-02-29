package com.automation.example.hybrid.pages;

import com.automation.example.hybrid.annotations.Page;
import io.qameta.allure.Allure;
import java.io.ByteArrayInputStream;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.springframework.beans.factory.annotation.Value;

@Page
public class LandingPage extends Base{

    @Value("${rhymezone-url}")
    private String url;

    public void goTo() {
        String urlPath = url;
        this.driver.get(urlPath);
        Allure.addAttachment("Page Verification", new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
    }

}
