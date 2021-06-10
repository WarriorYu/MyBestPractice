package com.example.mybestpractice.kotlin.CoroutineRetrofit

import com.google.gson.annotations.SerializedName

/**
 * @author   :   yuxibing
 * @date   :   2021/5/24
 * Describe :
 */
data class Banner(
        @SerializedName("id") var id: Long = 0,
        @SerializedName("title") var title: String = "",
        @SerializedName("desc") var desc: String = "",
        @SerializedName("url") var url: String = ""
)
