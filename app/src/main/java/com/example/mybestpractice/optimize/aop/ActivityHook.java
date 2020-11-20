package com.example.mybestpractice.optimize.aop;

import android.os.Bundle;

import androidx.annotation.Nullable;

import com.blankj.utilcode.util.LogUtils;



/**
 * @author :   yuxibing
 * @date :   2020/10/15
 * Describe : 统计页面打开时间，即onCreate到onWindowFocusChanged的时间
 */
public class ActivityHook {
   /* private static ActivityRecord mActivityRecord;

    static {
        mActivityRecord = new ActivityRecord();
    }

    @Insert(value = "onCreate", mayCreateSuper = true)
    @TargetClass(value = "androidx.appcompat.app.AppCompatActivity", scope = Scope.ALL)
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        mActivityRecord.mOnCreateTime = System.currentTimeMillis();
        Origin.callVoid();
    }

    @Insert(value = "onWindowFocusChanged", mayCreateSuper = true)
    @TargetClass(value = "android.app.Activity", scope = Scope.ALL)
    public void onWindowFocusChanged(boolean hasFocus) {
        mActivityRecord.mOnWindowsFocusChangedTime = System.currentTimeMillis();
        long costTime = mActivityRecord.mOnCreateTime = mActivityRecord.mOnWindowsFocusChangedTime;
        LogUtils.e("onWindowFocusChanged cost " + costTime);
    }*/
}
