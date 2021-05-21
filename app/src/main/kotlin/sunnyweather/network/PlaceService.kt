package com.example.mybestpractice.kotlin.sunnyweather.network

import com.example.mybestpractice.kotlin.BaseApplication
import com.example.mybestpractice.kotlin.sunnyweather.PlaceResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * @author   :   yuxibing
 * @date   :   2021/5/20
 * Describe :
 */
interface PlaceService {

    @GET("v2/place?token=${BaseApplication.TOKEN}&lang=zh_CN")
    fun searchPlace(@Query("query") query: String): Call<PlaceResponse>
}