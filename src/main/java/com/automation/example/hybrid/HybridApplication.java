package com.automation.example.hybrid;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * The main entry point for the application, starting the Spring boot application context for SSO.
 * Annotated with Spring Boot's @SpringBootApplication, enabling String Boot features.
 * and @EnableCaching, enabling caching for improved performance.
 */
@SpringBootApplication
@EnableCaching
public class HybridApplication {

	public static void main(String[] args) {
		SpringApplication.run(HybridApplication.class, args);
	}

}
