package com.example.mybestpractice.kotlin.sunnyweather.network

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * @author   :   yuxibing
 * @date   :   2021/5/14
 * Describe :
 */
object ServiceCreator {
    private const val BASE_URL = "https://api.caiyunapp.com/"

    private val logIntercepter = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }
    private val okHttpClient = OkHttpClient.Builder()
            .addInterceptor(logIntercepter)
            .build()

    private val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()

    fun <T> create(serviceClass: Class<T>): T = retrofit.create(serviceClass)
    //利用泛型实化，调用create的时候使用泛型代替传递T::class.java
    inline fun <reified T> create(): T = create(T::class.java)
}