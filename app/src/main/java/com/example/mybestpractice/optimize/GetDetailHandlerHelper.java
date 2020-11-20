package com.example.mybestpractice.optimize;

import android.os.Message;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @author :   yuxibing
 * @date :   2020/10/15
 * Describe :
 */
public class GetDetailHandlerHelper {
    private static ConcurrentHashMap<Message, String> sMsgDetail = new ConcurrentHashMap<>();

    public static ConcurrentHashMap<Message, String> getMsgDetail() {
        return sMsgDetail;
    }
}
