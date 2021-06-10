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

    /**
     * Call的写法
     */
    @GET("v2/place?token=${BaseApplication.TOKEN}&lang=zh_CN")
    fun searchPlace(@Query("query") query: String): Call<PlaceResponse>

    /**
     * 使用suspend,不使用Call
     */

//    @GET("v2/place?token=${BaseApplication.TOKEN}&lang=zh_CN")
//    suspend fun searchPlace(@Query("query") query: String): PlaceResponse
//
//
//    @GET("v2/place?token=${BaseApplication.TOKEN}&lang=zh_CN")
//    suspend fun searchPlaceTwo(@Query("query") query: String): PlaceResponse
}