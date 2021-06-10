package com.example.mybestpractice.kotlin.mycoroutineretrofit.base

import com.example.mybestpractice.kotlin.mycoroutineretrofit.ApiException

/**
 * @author   :   yuxibing
 * @date   :   2021/5/25
 * Describe :
 */
class BaseBean<T>( val errorCode: Int,  val errorMsg: String? = null,  val data: T) {
    /*fun statusCode(): Int {
        if (statusCode == 200) {
            return statusCode
        } else {
            throw ApiException(statusCode, statusMessage ?: "")
        }
    }

    fun data(): T {
        if (statusCode == 200) {
            return data
        } else {
            throw ApiException(statusCode, statusMessage ?: "")
        }
    }*/

}