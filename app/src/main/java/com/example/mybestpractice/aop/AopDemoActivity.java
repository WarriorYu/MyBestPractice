package com.example.mybestpractice.aop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.mybestpractice.R;
import com.example.mybestpractice.aop.annotation.ClickBehavior;
import com.example.mybestpractice.aop.annotation.LoginCheck;

public class AopDemoActivity extends AppCompatActivity {

    private static final String TAG = AopDemoActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aop_demo);
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
}
