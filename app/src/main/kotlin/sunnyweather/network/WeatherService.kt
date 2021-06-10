package com.example.mybestpractice.kotlin.sunnyweather.network

import com.example.mybestpractice.kotlin.BaseApplication
import com.example.mybestpractice.kotlin.sunnyweather.model.DailyResponse
import com.example.mybestpractice.kotlin.sunnyweather.model.RealtimeResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface WeatherService {

    /**
     * Call的写法
     */
    @GET("v2.5/${BaseApplication.TOKEN}/{lng},{lat}/realtime.json")
    fun getRealtimeWeather(@Path("lng") lng: String, @Path("lat") lat: String): Call<RealtimeResponse>

    @GET("v2.5/${BaseApplication.TOKEN}/{lng},{lat}/daily.json")
    fun getDailyWeather(@Path("lng") lng: String, @Path("lat") lat: String): Call<DailyResponse>

    /**
     * 使用suspend,不使用Call
     */
//    @GET("v2.5/${BaseApplication.TOKEN}/{lng},{lat}/realtime.json")
//    suspend fun getRealtimeWeather(@Path("lng") lng: String, @Path("lat") lat: String): RealtimeResponse
//
//    @GET("v2.5/${BaseApplication.TOKEN}/{lng},{lat}/daily.json")
//    suspend fun getDailyWeather(@Path("lng") lng: String, @Path("lat") lat: String): DailyResponse

}