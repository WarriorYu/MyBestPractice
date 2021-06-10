package com.example.mybestpractice.kotlin.CoroutineRetrofit

import retrofit2.http.GET

/**
 * @author   :   yuxibing
 * @date   :   2021/5/24
 * Describe :
 */
interface IApi {
    @GET("banner/json")
    suspend fun getBanner(): ResponseResult<List<Banner>>
}
