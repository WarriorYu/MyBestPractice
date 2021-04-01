package com.example.mybestpractice.kotlin

import android.app.Application
import android.content.Context

/**
 * @author   :   yuxibing
 * @date   :   2020/12/7
 * Describe :
 */
class BaseApplication : Application() {
    companion object {
        @JvmStatic
        @get:JvmName("currentApplication")
        lateinit var currentApplication: Context
            private set
    }

    override fun onCreate() {
        super.onCreate()
        currentApplication = this
    }
}