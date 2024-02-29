package com.automation.example.hybrid.annotations;

import java.lang.annotation.*;
import org.springframework.context.annotation.Configuration;

@LazyConfiguration
@Configuration
@Documented
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface LazyConfiguration {
}
