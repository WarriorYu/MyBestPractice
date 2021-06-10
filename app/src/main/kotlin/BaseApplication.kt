package com.example.mybestpractice.kotlin

import android.app.Application
import android.content.Context
import com.example.mybestpractice.kotlin.mooc.ActivityManager

/**
 * @author   :   yuxibing
 * @date   :   2020/12/7
 * Describe :
 */
class BaseApplication : Application() {
    companion object {
        const val TOKEN = "" // 填入你申请到的令牌值
        @JvmStatic
        @get:JvmName("currentApplication")
        lateinit var currentApplication: Context
            private set
    }

    override fun onCreate() {
        super.onCreate()
        currentApplication = applicationContext
        ActivityManager.instance.init(this)
    }
}