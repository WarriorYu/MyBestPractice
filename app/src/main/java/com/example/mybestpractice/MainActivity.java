package com.example.mybestpractice;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.speech.RecognitionService;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Choreographer;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;

import com.blankj.utilcode.util.LogUtils;
import com.example.mybestpractice.aop.AopDemoActivity;
import com.example.mybestpractice.customview.CustomViewActivity;
import com.example.mybestpractice.databinding.ActivityMainBinding;
import com.example.mybestpractice.kotlin.Main2Activity;
import com.example.mybestpractice.kotlin.Utils;
import com.example.mybestpractice.kotlin.rxjava3.Rxjava3Activity;
import com.example.mybestpractice.kotlin.sunnyweather.model.DailyResponse;
import com.example.mybestpractice.kotlin.sunnyweather.network.WeatherService;
import com.example.mybestpractice.mooctixi.ExecutorActivity;
import com.example.mybestpractice.mvvm.MVVMActivity;
import com.example.mybestpractice.optimize.OptimizeActivity;
import com.example.mybestpractice.service.TestSertviceActivity;
import com.example.mybestpractice.util.LaunchTimer;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        LaunchTimer.endRecord("onWindowFocusChanged");
        Choreographer.getInstance().postFrameCallback(new Choreographer.FrameCallback() {
            @Override
            public void doFrame(long frameTimeNanos) {
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);


        /**
         *             case R.id.service:
         *                 startActivity(new Intent(this, TestSertviceActivity.class));
         *                 break;
         *             case R.id.custom_view:
         *                 startActivity(new Intent(this, CustomViewActivity.class));
         *                 break;
         *             case R.id.kotlin:
         *                 startActivity(new Intent(this, Main2Activity.class));
         *                 break;
         *             case R.id.optimize:
         *                 startActivity(new Intent(this, OptimizeActivity.class));
         *                 break;
         *             case R.id.mvvm:
         *                 startActivity(new Intent(this, MVVMActivity.class));
         *                 break;
         *             case R.id.Rxjava3:
         *                 // HencoderPlus 解析Rxjava3源码
         *                 startActivity(new Intent(this, Rxjava3Activity.class));
         *
         * //                HandlerThread handlerThread = new HandlerThread("handler-thread");
         * //                handlerThread.start();
         * //                Log.e("handlerThread", ":" + (handlerThread.getLooper() == Looper.getMainLooper()));
         *                 break;
         *
         *             case R.id.executor:
         *
         *                 break;
         */

        binding.aop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, AopDemoActivity.class));

            }
        });

        binding.service.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, TestSertviceActivity.class));

            }
        });

        binding.customView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, CustomViewActivity.class));
            }
        });

        binding.kotlin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Main2Activity.class));

            }
        });

        binding.optimize.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, OptimizeActivity.class));
            }
        });

        binding.mvvm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, MVVMActivity.class));
            }
        });

        binding.Rxjava3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // HencoderPlus 解析Rxjava3源码
                startActivity(new Intent(MainActivity.this, Rxjava3Activity.class));

                //                HandlerThread handlerThread = new HandlerThread("handler-thread");
                //                handlerThread.start();
                //                Log.e("handlerThread", ":" + (handlerThread.getLooper() == Looper.getMainLooper()));
            }
        });

        binding.executor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, ExecutorActivity.class));
            }
        });

        /*Retrofit retrofit = new Retrofit.Builder().baseUrl("http://kkkk").build();
        WeatherService service = retrofit.create(WeatherService.class);
        service.getDailyWeather("","").enqueue(new Callback<DailyResponse>() {
            @Override
            public void onResponse(Call<DailyResponse> call, Response<DailyResponse> response) {

            }

            @Override
            public void onFailure(Call<DailyResponse> call, Throwable t) {

            }
        });*/


      /*  btn.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() {
            @Override
            public boolean onPreDraw() {
                btn.getViewTreeObserver().removeOnPreDrawListener(this);
                LaunchTimer.endRecord("addOnPreDrawListener");
                return true;
            }
        });*/
        /*btn.getViewTreeObserver().addOnDrawListener(new ViewTreeObserver.OnDrawListener() {
            @Override
            public void onDraw() {
                LaunchTimer.endRecord("addOnDrawListener");
            }
        });*/


        OkHttpClient client = new OkHttpClient.Builder().readTimeout(10, TimeUnit.SECONDS).build();
        Request request = new Request.Builder().get().url("http://www.baidu.com").build();
        okhttp3.Call call = client.newCall(request);


        // 方式一：同步请求
        try {
            Response response = call.execute();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 方式二：异步请求
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                LogUtils.e(response.toString());

            }
        });


//        BaseApplication.currentApplication();

//        Utils.INSTANCE.toast("单参数");
//        Utils.INSTANCE.toast("双参数", Toast.LENGTH_LONG);

        /*HandlerThread handlerThread = new HandlerThread("handlerThread");
        handlerThread.start();
        Handler handler = new Handler(handlerThread.getLooper());
        Log.e("looper:",(handlerThread.getLooper() == Looper.getMainLooper())+"");*/
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        return super.dispatchTouchEvent(ev);
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.e("onRestart", "onRestart");

    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.e("onStart", "onStart");

    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e("onResume", "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e("onPause", "onPause");

    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e("onStop", "onStop");

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e("onDestroy", "onDestroy");

    }
}
