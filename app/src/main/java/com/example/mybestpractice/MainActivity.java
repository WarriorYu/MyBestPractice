package com.example.mybestpractice;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
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

import com.example.mybestpractice.aop.AopDemoActivity;
import com.example.mybestpractice.customview.CustomViewActivity;
import com.example.mybestpractice.kotlin.Main2Activity;
import com.example.mybestpractice.kotlin.Utils;
import com.example.mybestpractice.kotlin.rxjava3.Rxjava3Activity;
import com.example.mybestpractice.mvvm.MVVMActivity;
import com.example.mybestpractice.optimize.OptimizeActivity;
import com.example.mybestpractice.service.TestSertviceActivity;
import com.example.mybestpractice.util.LaunchTimer;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


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

    private Handler handler = new Handler() {
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
        }

    };


    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        LaunchTimer.endRecord("onWindowFocusChanged");
        Choreographer.getInstance().postFrameCallback(new Choreographer.FrameCallback() {
            @Override
            public void doFrame(long frameTimeNanos) {

            }
        });

        Message message = new Message();
        message.what = 1;
        handler.sendMessage(Message.obtain());

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
        });*/

//        BaseApplication.currentApplication();

        Utils.INSTANCE.toast("单参数");
        Utils.INSTANCE.toast("双参数", Toast.LENGTH_LONG);

        HashMap<String, Integer> map = new HashMap<>();
        Set<Map.Entry<String, Integer>> entrySet = map.entrySet();
        for (Map.Entry<String, Integer> entry : entrySet) {
            System.out.println(entry.getKey() + "" + entry.getValue());

        }

    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        return super.dispatchTouchEvent(ev);
    }

    public void service(View view) {
    }

    @OnClick({R.id.aop, R.id.service, R.id.custom_view, R.id.kotlin, R.id.optimize, R.id.mvvm, R.id.Rxjava3})
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
            case R.id.mvvm:
                startActivity(new Intent(this, MVVMActivity.class));
                break;
            case R.id.Rxjava3:
                // HencoderPlus 解析Rxjava3源码
                startActivity(new Intent(this, Rxjava3Activity.class));

//                HandlerThread handlerThread = new HandlerThread("handler-thread");
//                handlerThread.start();
//                Log.e("handlerThread", ":" + (handlerThread.getLooper() == Looper.getMainLooper()));
                break;
            default:
        }
    }

    @Nullable
    @Override
    public Object onRetainCustomNonConfigurationInstance() {
        return super.onRetainCustomNonConfigurationInstance();
    }
}
