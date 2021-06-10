package com.example.mybestpractice.kotlin.sunnyweather.network

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException
import kotlin.coroutines.suspendCoroutine

/**
 * @author   :   yuxibing
 * @date   :   2021/5/20
 * Describe :
 */
object SunnyWeatherNetWork {
    private val placeService = ServiceCreator.create<PlaceService>()

    private val weatherService = ServiceCreator.create(WeatherService::class.java)


    /**
     * Retrofit使用suspend的写法
     */
//    suspend fun searchPlaces(query: String) = placeService.searchPlace(query)
//
//    suspend fun getDailyWeather(lng: String, lat: String) = weatherService.getDailyWeather(lng, lat)
//
//    suspend fun getRealtimeWeather(lng: String, lat: String) = weatherService.getRealtimeWeather(lng, lat)

    suspend fun searchPlacesTwo(query: String) = placeService.searchPlace(query)



    /**
     * Retrofit 使用Call的写法
     */
    suspend fun searchPlaces(query: String) = placeService.searchPlace(query).await()

    suspend fun getDailyWeather(lng: String, lat: String) = weatherService.getDailyWeather(lng, lat).await()

    suspend fun getRealtimeWeather(lng: String, lat: String) = weatherService.getRealtimeWeather(lng, lat).await()

     private suspend fun <T> Call<T>.await(): T {
        return suspendCoroutine { continuation ->
            enqueue(object : Callback<T> {
                override fun onResponse(call: Call<T>, response: Response<T>) {
                    val body = response.body()
                    if (body != null) {
                        continuation.resume(body)
                    } else {
                        continuation.resumeWithException(RuntimeException("response body is null"))
                    }
                }

                override fun onFailure(call: Call<T>, t: Throwable) {
                    continuation.resumeWithException(t)
                }
            })
        }
    }






}