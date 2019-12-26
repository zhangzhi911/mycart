package com.zhangzhi.annotation;

import org.springframework.stereotype.Component;

import java.lang.annotation.*;


@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Component
public @interface Pagable {
//    这个类是注解

}