package com.example.mybestpractice.kotlin.CoroutineRetrofit

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * @author   :   yuxibing
 * @date   :   2021/5/24
 * Describe :
 */
object Api {
    private val api by lazy {
        val retrofit = Retrofit.Builder()
                .baseUrl("https://www.wanandroid.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(OkHttpClient.Builder().build())
                .build()
        retrofit.create(IApi::class.java)
    }
    fun get(): IApi {
        return api
    }
}
