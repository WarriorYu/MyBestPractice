package com.example.mybestpractice.kotlin.mycoroutineretrofit

import androidx.lifecycle.liveData
import java.lang.RuntimeException

/**
 * @author   :   yuxibing
 * @date   :   2021/5/28
 * Describe :
 */
object HomeRepository {

    fun getBanner() = fire {
        val banner = PlayAndroidNetwork.getBanner()
        if (banner.errorCode == 0) {
            Result.success(banner.data)
        } else {
            val apiException = ApiException(banner.errorCode, banner.errorMsg ?: "")
            Result.failure(apiException)
//            Result.failure(RuntimeException("resonse status is ${banner.errorCode} msg is ${banner.errorMsg}"))
        }
    }

    fun <T> fire(block: suspend () -> Result<T>) =
        liveData {
            val result = try {
                block()
            } catch (e: Exception) {
                Result.failure(e)
            }
            emit(result)

    }
}