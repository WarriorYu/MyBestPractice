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
    public static List<ICallBack> sCallBacks = new ArrayList<>();
    public static void addCallBack(ICallBack callBack) {
        sCallBacks.add(callBack);
    }

    public void removeCallBack(ICallBack callBack) {
        sCallBacks.remove(callBack);
    }
}
