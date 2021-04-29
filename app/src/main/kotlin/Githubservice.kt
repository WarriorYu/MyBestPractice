package com.example.mybestpractice.kotlin

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path


/**
 * @author   :   yuxibing
 * @date   :   2021-04-20
 * Describe :
 */
interface GitHubService{
    @GET("users/{user}/repos")
    fun listRepos(@Path("user") user: String): Call<List<Repo>>
}
