package com.example.mybestpractice.kotlin.mycoroutineretrofit

/**
 * 版权：Zhujiang 个人版权
 *
 * @author zhujiang
 * 创建日期：2020/9/16
 * 描述：PlayAndroid
 *
 */

data class BannerBean(
    val uid: Int = 0,
    val desc: String,
    val id: Int,
    val imagePath: String,
    val isVisible: Int,
    val order: Int,
    val title: String,
    val type: Int,
    val url: String,
    var filePath: String
)