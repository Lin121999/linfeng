package com.linfeng.lfspring.annotation;

import java.lang.annotation.*;

@Documented
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface LFAutowired {
    String value() default "";
}
