package com.example.mybestpractice.aop.aspect;

import android.content.Context;
import android.content.Intent;

import com.example.mybestpractice.aop.LoginActivity;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

/**
 * @author :   yuxibing
 * @date :   2020-07-09
 * Describe : 登录的切面类
 */
@Aspect
public class LoginCheckAspect {

    @Pointcut("execution(@com.example.mybestpractice.aop.annotation.LoginCheck * *(..))")
    public void methodPointCut() {
    }

    @Around("methodPointCut()")
    public Object joinPoint(ProceedingJoinPoint joinPoint) {
        Context context = (Context) joinPoint.getThis();
        if (false) {// 在 sharePreferences 里获取
            try {
                Object result = joinPoint.proceed();
                return result;
            } catch (Throwable throwable) {
                throwable.printStackTrace();
            }

        } else {
            context.startActivity(new Intent(context, LoginActivity.class));
        }
        return null;
    }
}
