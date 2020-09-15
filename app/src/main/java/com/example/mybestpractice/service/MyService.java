package com.example.mybestpractice.service;

import android.annotation.TargetApi;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.graphics.Color;
import android.os.Binder;
import android.os.Build;
import android.os.IBinder;
import android.util.Log;

import androidx.annotation.RequiresApi;
import androidx.core.app.NotificationCompat;

import com.example.mybestpractice.MainActivity;
import com.example.mybestpractice.R;

import java.security.PublicKey;
import java.util.HashMap;
import java.util.Hashtable;

/**
 * @author : yuxibing
 * @date : 2020-09-07
 * Describe : 本地Service
 */
public class MyService extends Service {
    private static final String TAG = "MyService";
    public static final int NOTIFICATION_ID = 412;


    private MyBinder myBinder = new MyBinder();
    private onSetActivityData listener;

    @Override
    public void onCreate() {
        super.onCreate();
        Log.e(TAG, "onCreate");

        //添加下列代码将后台Service变成前台Service
        //构建"点击通知后打开MainActivity"的Intent对象
        setForegroundService();
    }

    @TargetApi(Build.VERSION_CODES.O)
    public void setForegroundService() {
        //设定的通知渠道名称
        String channelName = "观复channelName";
        String CHANNEL_ID = "观复CHANNEL_ID";
        String description = "观复description";
        //设置通知的重要程度
        int importance = NotificationManager.IMPORTANCE_LOW;
        //构建通知渠道
        NotificationChannel channel = new NotificationChannel(CHANNEL_ID, channelName, importance);
        channel.setDescription(description);
        Intent notificationIntent = new Intent(this,MainActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this,0,notificationIntent,0);
        //在创建的通知渠道上发送通知
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, CHANNEL_ID);
        builder.setSmallIcon(R.mipmap.ic_launcher) //设置通知图标
                .setContentTitle("前台服务通知的标题")//设置通知标题
                .setContentText("前台服务通知的内容")//设置通知内容
                .setContentIntent(pendingIntent)
                .setAutoCancel(true) //用户触摸时，自动关闭
                .setOngoing(true);//设置处于运行状态

        //向系统注册通知渠道，注册后不能改变重要性以及其他通知行为
        NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.createNotificationChannel(channel);
        //将服务置于启动状态 NOTIFICATION_ID指的是创建的通知的ID
        startForeground(NOTIFICATION_ID, builder.build());

    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.e(TAG, "onStartCommand");
        if (listener != null) {
            listener.getData();
        }
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.e(TAG, "onDestroy");
    }

    @Override
    public IBinder onBind(Intent intent) {
        Log.e(TAG, "onBind");
        return myBinder;
    }

    @Override
    public void onRebind(Intent intent) {
        super.onRebind(intent);
        Log.e(TAG, "onRebind");
    }
    public interface onSetActivityData{
        void getData();
    }

    public void setActivityDataListener(onSetActivityData listener){
        this.listener = listener;
    }


    @Override
    public boolean onUnbind(Intent intent) {
        Log.e(TAG, "onUnbind");
        return super.onUnbind(intent);
    }

    public class MyBinder extends Binder {
        public void serviceConnectActivity() {
            Log.e(TAG, "MyBinder - serviceConnectActivity");
        }

        public MyService getService() {
            return MyService.this;
        }
    }

}
