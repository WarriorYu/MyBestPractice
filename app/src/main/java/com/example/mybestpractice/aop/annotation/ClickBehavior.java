package com.example.mybestpractice.aop.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author :   yuxibing
 * @date :   2020-07-08
 * Describe : 用户点击痕迹
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)//目标作用在方法上
public @interface ClickBehavior {
    String value();
}
