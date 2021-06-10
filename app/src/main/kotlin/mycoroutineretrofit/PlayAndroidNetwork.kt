package com.example.mybestpractice.kotlin.mycoroutineretrofit

/**
 * @author   :   yuxibing
 * @date   :   2021/5/28
 * Describe :
 */
object PlayAndroidNetwork {
    private val service = WanServiceCreator.create<HomePageService>()
    suspend fun getBanner() = service.getBanner()
}