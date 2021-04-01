package com.example.mybestpractice.mvvm;

import android.nfc.Tag;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.OnLifecycleEvent;

/**
 * @author :   yuxibing
 * @date :   2021-02-03
 * Describe :
 */
public class MyObserver implements DefaultLifecycleObserver {
    private static final String TAG = MyObserver.class.getSimpleName();

    // java8是这种写法
    @Override
    public void onResume(@NonNull LifecycleOwner owner) {
        Log.e(TAG, "非注解：" + "onResume");
    }

    @Override
    public void onPause(@NonNull LifecycleOwner owner) {
        Log.e(TAG, "非注解：" + "onPause");
    }

    // java7是这种写法
   /* @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public void connectListener() {
        Log.e(TAG, "注解：" + "onResume");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    public void disconnectListener() {
        Log.e(TAG, "注解：" + "onPause");
    }*/
}
