package com.example.mybestpractice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.mybestpractice.aop.OtherActivity;
import com.example.mybestpractice.aop.annotation.ClickBehavior;
import com.example.mybestpractice.aop.annotation.LoginCheck;


import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;


public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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

            }
        });


    }

    @ClickBehavior("登录")
    public void login(View view) {
        Log.e(TAG, "模拟接口请求……验证通过，登录成功！");
    }

    @LoginCheck
    public void area(View view) {
        startActivity(new Intent(this, OtherActivity.class));
    }

    public void coupon(View view) {
    }

    public void score(View view) {

    }

    @Override
    protected void onRestart() {
        super.onRestart();
    }

    @Override
    protected void onStart() {
        super.onStart();
    }
}
