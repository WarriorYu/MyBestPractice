package com.example.mybestpractice.kotlin

import android.content.Context
import android.widget.Toast

/**
 * @author   :   yuxibing
 * @date   :   2021/5/20
 * Describe : 简化Toast的使用
 */
fun String.showToast(duration: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(BaseApplication.currentApplication, this, duration).show()
}

fun Int.showToast( duration: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(BaseApplication.currentApplication, this, duration).show()
}