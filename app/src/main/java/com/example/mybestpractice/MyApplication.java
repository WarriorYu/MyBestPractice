package com.example.mybestpractice;

import android.app.Application;
import android.content.Context;
import android.os.Handler;

/**
 * @author :   yuxibing
 * @date :   2020-09-16
 * Describe :
 */
public class MyApplication extends Application {
    public static Context context;
    public static Handler mainHandler;

    @Override
    public void onCreate() {
        super.onCreate();
        context = this;
        mainHandler = new Handler();

    }
}
