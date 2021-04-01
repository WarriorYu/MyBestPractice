package com.example.mybestpractice.kotlin

import android.util.Log

/**
 * @author   :   yuxibing
 * @date   :   2020/12/7
 * Describe :
 */
fun main() {
    log("log")
}

inline fun log(text: String) {
    Log.e("Tag", text)
}