package com.example.mybestpractice.util;

import com.blankj.utilcode.util.LogUtils;

/**
 * @author :   yuxibing
 * @date :   2020/9/29
 * Describe : 记录启动时间
 */
public class LaunchTimer {

    private static long sTime;

    public static void startRecod() {
        sTime = System.currentTimeMillis();
    }

    public static void endRecord() {
        endRecord("");
    }

    public static void endRecord(String msg) {
        long cost = System.currentTimeMillis() - sTime;
//        LogUtils.e(msg + " cost " + cost);
    }
}
