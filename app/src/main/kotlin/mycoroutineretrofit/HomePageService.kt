package com.example.mybestpractice.kotlin.mycoroutineretrofit

import com.example.mybestpractice.kotlin.mycoroutineretrofit.base.BaseBean
import retrofit2.http.GET

/**
 * @author   :   yuxibing
 * @date   :   2021/5/28
 * Describe :
 */
interface HomePageService {
    @GET("banner/json")
    suspend fun getBanner(): BaseBean<List<BannerBean>>
}