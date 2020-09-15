package com.example.mybestpractice;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.mybestpractice.aop.AopDemoActivity;
import com.example.mybestpractice.customview.CustomViewActivity;
import com.example.mybestpractice.service.TestSertviceActivity;

import butterknife.ButterKnife;
import butterknife.OnClick;


public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        Log.e(TAG, "onCreate");
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

            }
        });*/


    }


    public void service(View view) {
    }

    @OnClick({R.id.aop, R.id.service, R.id.custom_view})
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
            default:
        }
    }
}
