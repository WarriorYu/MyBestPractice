package com.example.mybestpractice;

import android.app.Application;
import android.content.Context;
import android.os.Debug;
import android.os.Handler;
import android.os.Message;

import androidx.annotation.NonNull;
import androidx.core.os.TraceCompat;

import com.example.mybestpractice.util.LaunchTimer;

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
//        Debug.startMethodTracing("testTraceviewe");
//        TraceCompat.beginSection("testSystrace");
        context = this;
        mainHandler = new Handler();
//        Debug.stopMethodTracing();
//        TraceCompat.endSection();

    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        LaunchTimer.startRecod();
    }
}
