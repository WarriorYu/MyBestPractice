package com.example.mybestpractice.optimize;

import android.app.Activity;

import java.util.ArrayList;
import java.util.List;

/**
 * @author :   yuxibing
 * @date :   2020/9/30
 * Describe :
 */
public class CallBackManager{
    //静态的生命周期和应用生命周期一样，所以会导致OptimizeActivity内存泄漏
    public static List<ICallBack> sCallBacks = new ArrayList<>();
    public static void addCallBack(ICallBack callBack) {
        sCallBacks.add(callBack);
    }

    public static void removeCallBack(ICallBack callBack) {
        sCallBacks.remove(callBack);
    }
}
