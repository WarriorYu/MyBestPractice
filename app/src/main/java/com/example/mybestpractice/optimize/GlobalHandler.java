package com.example.mybestpractice.optimize;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;

import com.blankj.utilcode.util.LogUtils;

import org.json.JSONObject;

/**
 * @author :   yuxibing
 * @date :   2020/10/15
 * Describe : 耗时盲区监控线上方案
 *
 * - 使用统一的Handler：定制具体方法。即发送消息最终执行的方法sendMessageAtTime()，和处理消息最终执行的方法dispatchMessage()。
 * - 定制gradle插件，编译期动态替换handler的父类，替换成我们这个统一的Handler，这样项目中所有sendMessage和dispatchMessage的地方都执行我们自己的回调。
 */
public class GlobalHandler extends Handler {

    private long mStartTime = System.currentTimeMillis();

    public GlobalHandler() {
        super(Looper.myLooper(), null);
    }

    public GlobalHandler(Callback callback) {
        super(Looper.myLooper(), callback);
    }

    public GlobalHandler(Looper looper, Callback callback) {
        super(looper, callback);
    }

    public GlobalHandler(Looper looper) {
        super(looper);
    }

    @Override
    public boolean sendMessageAtTime(Message msg, long uptimeMillis) {
        Log.e("MsgDetail", "sendMessageAtTime");

        boolean send = super.sendMessageAtTime(msg, uptimeMillis);
        // 1
        if (send) {
            GetDetailHandlerHelper.getMsgDetail().put(msg, Log.getStackTraceString(new Throwable()).replace("java.lang.Throwable", ""));
        }
        return send;
    }

    @Override
    public void dispatchMessage(Message msg) {
        mStartTime = System.currentTimeMillis();
        super.dispatchMessage(msg);

        if (GetDetailHandlerHelper.getMsgDetail().containsKey(msg) && Looper.myLooper() == Looper.getMainLooper()) {
            JSONObject jsonObject = new JSONObject();
            try {
                // 2
                jsonObject.put("Msg_Cost", System.currentTimeMillis() - mStartTime);
                jsonObject.put("MsgTrace", msg.getTarget() + " " + GetDetailHandlerHelper.getMsgDetail().get(msg));

                // 3
                LogUtils.e("MsgDetail " + jsonObject.toString());
                Log.e("MsgDetail", jsonObject.toString());
                GetDetailHandlerHelper.getMsgDetail().remove(msg);
            } catch (Exception e) {
            }
        }
    }
}