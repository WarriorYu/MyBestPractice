package com.example.mybestpractice;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.mybestpractice.aop.AopDemoActivity;
import com.example.mybestpractice.customview.CustomViewActivity;
import com.example.mybestpractice.kotlin.Main2Activity;
import com.example.mybestpractice.optimize.OptimizeActivity;
import com.example.mybestpractice.service.TestSertviceActivity;
import com.example.mybestpractice.util.LaunchTimer;

import org.greenrobot.eventbus.EventBus;

import java.io.IOException;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import kotlinx.coroutines.GlobalScope;
import leakcanary.LeakCanary;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;


public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    @BindView(R.id.aop)
    Button btn;

//    @Override
//    protected void onSaveInstanceState(@NonNull Bundle outState) {
//        super.onSaveInstanceState(outState);
//    }
//
//    @Override
//    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
//        super.onRestoreInstanceState(savedInstanceState);
//    }


    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        LaunchTimer.endRecord("onWindowFocusChanged");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        Log.e(TAG, "onCreate");
      /*  btn.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() {
            @Override
            public boolean onPreDraw() {
                btn.getViewTreeObserver().removeOnPreDrawListener(this);
                LaunchTimer.endRecord("addOnPreDrawListener");
                return true;
            }
        });*/
        btn.getViewTreeObserver().addOnDrawListener(new ViewTreeObserver.OnDrawListener() {
            @Override
            public void onDraw() {
                LaunchTimer.endRecord("addOnDrawListener");
            }
        });



       /* OkHttpClient client = new OkHttpClient.Builder().readTimeout(10, TimeUnit.SECONDS).build();
        Request request = new Request.Builder().get().url("http://www.baidu.com").build();
        okhttp3.Call call = client.newCall(request);


        // 方式一：同步请求
//        try {
//            Response response = call.execute();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        // 方式二：异步请求
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {

            }
        });*/


    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        return super.dispatchTouchEvent(ev);
    }

    public void service(View view) {
    }

    @OnClick({R.id.aop, R.id.service, R.id.custom_view, R.id.kotlin, R.id.optimize})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.aop:
                startActivity(new Intent(this, AopDemoActivity.class));
                break;
            case R.id.service:
                startActivity(new Intent(this, TestSertviceActivity.class));
                break;
            case R.id.custom_view:
                startActivity(new Intent(this, CustomViewActivity.class));
                break;
            case R.id.kotlin:
                startActivity(new Intent(this, Main2Activity.class));
                break;
            case R.id.optimize:
                startActivity(new Intent(this, OptimizeActivity.class));
                break;
            default:
        }
    }
}
