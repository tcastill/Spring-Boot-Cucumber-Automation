package com.automation.example.hybrid.pages;

import com.automation.example.hybrid.annotations.Page;
import java.util.*;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.beans.factory.annotation.Value;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Slf4j
@Page
public class LandingPage extends Base{

    @Value("${rhymezone-url}")
    private String url;

    @FindBy(id = "rzinput")
    private WebElement textBox;

    public void goTo() {
        String urlPath = url;
        this.driver.get(urlPath);
        takeScreenshot();
    }

    public void enterWord(String text) {
        textBox.isDisplayed();
        textBox.sendKeys(text);
        textBox.getText().equals(text);
        takeScreenshot();
    }

    public void getAllLinks() {

        Map<String, String> expectedLinks = new HashMap<>();
        expectedLinks.put("Play Now", "https://www.merriam-webster.com/games/twofer-goofer");
        expectedLinks.put("Advanced search", "https://www.rhymezone.com/adv/");
        expectedLinks.put("Help", "https://www.rhymezone.com/help/");
        expectedLinks.put("Feedback", "https://docs.google.com/forms/d/e/1FAIpQLSfZIJ8xjp9uIVKwyYRMlh1ie6s1u3tmtcLUsGjplbgD8m0FXg/viewform");
        expectedLinks.put("Privacy", "https://www.rhymezone.com/privacy-policy");
        expectedLinks.put("Terms of Use", "https://www.rhymezone.com/terms-of-use");
        expectedLinks.put("Do not sell or share my personal information.", "https://www.rhymezone.com/#");

        List<String> verification = new ArrayList<>();

        List<WebElement> elements =driver. findElements(By. xpath("//*[@href]"));
        for (WebElement element : elements) {
            if(!element.getText().isEmpty()) {
                String linkName = expectedLinks.get(element.getText());
                String linkValue = element.getAttribute("href");
                log.info("Checking if page is directing correctly to URL: {} to match with {}", linkName, linkValue);
                assertEquals(linkValue, linkName);
                verification.add(linkName);
            }
        }
        addLog("Verified Passing", Arrays.toString(new List[]{verification}));
    }
}