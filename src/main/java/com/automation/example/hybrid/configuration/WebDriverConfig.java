package com.automation.example.hybrid.configuration;

import com.automation.example.hybrid.annotations.LazyConfiguration;
import com.automation.example.hybrid.annotations.ThreadScopeBean;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

@Profile("!remote")
@LazyConfiguration
public class WebDriverConfig {

    @Value("${headless}")
    private boolean headless;

    @Value("${language-code}")
    private String language;

    @Primary
    @ThreadScopeBean
    @ConditionalOnProperty(name = "browser", havingValue = "firefox")
    public WebDriver firefoxDriver() {
        WebDriverManager.firefoxdriver().setup();
        FirefoxOptions firefoxOptions = new FirefoxOptions();

        firefoxOptions.addArguments("-private");
        //todo
        //firefox headless option
        //firefoxOptions.setHeadless(headless);
        return new FirefoxDriver(firefoxOptions);
    }

    @Primary
    @ThreadScopeBean
    @ConditionalOnProperty(name = "browser", havingValue = "chrome")
    public WebDriver chromeDriver() {
        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-gpu");
        options.addArguments("--disable-extensions");
        options.addArguments("--disable-web-security");
        options.addArguments("--allow-running-insecure-content");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--window-size=1580,1280");
        options.addArguments("disable-gpu", "--ignore-certificate-errors");

        //logging
        LoggingPreferences logPrefs = new LoggingPreferences();
        logPrefs.enable(LogType.PERFORMANCE, Level.ALL);
        options.setCapability("goog:loggingPrefs", logPrefs);

        if (headless) {
            options.addArguments("--headless");
        }

        Map<String, Object> prefs = new HashMap<>();
        prefs.put("intl.accept_languages", "en");
        options.setExperimentalOption("prefs", prefs);

        return new ChromeDriver(options);
    }

    @Primary
    @ThreadScopeBean
    @ConditionalOnProperty(name = "browser", havingValue = "edge")
    public WebDriver edgeDriver() {
        return new EdgeDriver();
    }
}
