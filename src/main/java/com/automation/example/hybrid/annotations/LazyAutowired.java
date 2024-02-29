package com.automation.example.hybrid.annotations;

import java.lang.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

@LazyAutowired
@Autowired
@Documented
@Target({ElementType.FIELD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface LazyAutowired {
}
