package com.example.mybestpractice.kotlin

import android.widget.Toast

/**
 * @author   :   yuxibing
 * @date   :   2020/12/7
 * Describe :
 */

object Utils {
    @JvmOverloads
    fun toast(string: String, duration: Int = Toast.LENGTH_SHORT) {
        Toast.makeText(BaseApplication.currentApplication,string,duration).show()
    }
}