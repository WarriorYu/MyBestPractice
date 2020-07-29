package com.example.mybestpractice.aop.aspect;

import android.nfc.Tag;
import android.util.Log;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

/**
 * @author :   yuxibing
 * @date :   2020-07-09
 * Describe :
 */
@Aspect
public class LogAspect {
    static final String TAG = "LogAspect";

    @Pointcut("execution(* com.example.mybestpractice.MainActivity.onCreate(..)) ||" + "execution(* com.example.mybestpractice.MainActivity.onStart(..))")
    public void logForActivity() {
    }

    @Before("logForActivity()")
    public void log(JoinPoint joinPoint) {
        Log.e(TAG, joinPoint.toShortString());
    }
}
