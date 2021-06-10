package com.example.mybestpractice.kotlin.CoroutineRetrofit

import com.google.gson.annotations.SerializedName

/**
 * @author   :   yuxibing
 * @date   :   2021/5/24
 * Describe :
 */
data class ResponseResult<T>(
        @SerializedName("errorCode") var errorCode: Int = -1,
        @SerializedName("errorMsg") var errorMsg: String? = "",
        @SerializedName("data") var data: T? = null
)
