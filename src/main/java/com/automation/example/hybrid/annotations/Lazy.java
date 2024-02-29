package com.automation.example.hybrid.annotations;

import java.lang.annotation.*;
import org.springframework.stereotype.Component;

@Lazy
@Component
@Documented
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface Lazy {
}
