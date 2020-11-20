package com.example.mybestpractice;

import android.app.Application;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Debug;
import android.os.Handler;
import android.os.Message;
import android.os.MessageQueue;
import android.util.Log;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.core.os.TraceCompat;

import com.blankj.utilcode.util.LogUtils;
import com.example.mybestpractice.optimize.ImageHook;
import com.example.mybestpractice.util.LaunchTimer;
import com.taobao.android.dexposed.DexposedBridge;
import com.taobao.android.dexposed.XC_MethodHook;

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
//        Debug.startMethodTracing("testTraceview");
//        TraceCompat.beginSection("testSystrace");
        context = this;
        mainHandler = new Handler();
//        Debug.stopMethodTracing();
//        TraceCompat.endSection();


        // 通过调用 DexposedBridge 的 findAndHookMethod 方法找到所有通过 ImageView 的 setImageBitmap 方法设置的切入点，
        // 其中最后一个参数 ImageHook 对象是继承了 XC_MethodHook 类，
        // 其目的是为了 重写 afterHookedMethod 方法拿到相应的参数进行监控逻辑的判断。
        /*DexposedBridge.hookAllConstructors(ImageView.class, new XC_MethodHook() {
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                super.afterHookedMethod(param);
                DexposedBridge.findAndHookMethod(ImageView.class, "setImageBitmap", Bitmap.class, new ImageHook());
            }
        });
*/
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        LaunchTimer.startRecod();

        // Hook所有创建线程的地方，然后打印线程名字和堆栈信息，依次来查看有没有随意创建线程的情况
        /*DexposedBridge.hookAllConstructors(Thread.class, new XC_MethodHook() {
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                super.afterHookedMethod(param);
                Thread thread = (Thread) param.thisObject;
                Log.e(thread.getName()," stack " + Log.getStackTraceString(new Throwable()));
            }
        });*/
    }

    @Override
    public void onTrimMemory(int level) {
        super.onTrimMemory(level);
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
    }
}
