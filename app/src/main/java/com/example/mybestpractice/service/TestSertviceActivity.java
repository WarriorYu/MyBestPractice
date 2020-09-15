package com.example.mybestpractice.service;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.view.View;

import com.example.mybestpractice.R;

/**
 * @author : yuxibing
 * @date : 2020-09-15
 * Describe : 服务的两种启动方式，以及Servie和Activity传值
 */
public class TestSertviceActivity extends AppCompatActivity {
    private MyServiceConnection connection = new MyServiceConnection();
    private MyService.MyBinder myBinder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_sertvice);

        findViewById(R.id.startService).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TestSertviceActivity.this, MyService.class);
                startService(intent);
            }
        });
        findViewById(R.id.stopService).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TestSertviceActivity.this, MyService.class);
                stopService(intent);
            }
        });
        findViewById(R.id.bindService).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TestSertviceActivity.this, MyService.class);
                bindService(intent, connection, BIND_AUTO_CREATE);
            }
        });
        findViewById(R.id.unbindService).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                unbindService(connection);
            }
        });
    }

    private class MyServiceConnection implements ServiceConnection {

        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            myBinder = (MyService.MyBinder) service;
            //实现activity给service通信
            myBinder.serviceConnectActivity();
            myBinder.getService().setActivityDataListener(new MyService.onSetActivityData() {
                @Override
                public void getData() {
                    //实现service给activity通信
                }
            });
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    }
}
