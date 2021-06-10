package com.example.mybestpractice.kotlin.mycoroutineretrofit.base

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.blankj.utilcode.util.ToastUtils
import com.example.mybestpractice.kotlin.mycoroutineretrofit.ApiException
import com.google.gson.JsonParseException
import kotlinx.coroutines.*
import retrofit2.HttpException
import java.net.ConnectException
import java.net.SocketTimeoutException
import java.net.UnknownHostException

/**
 * @author   :   yuxibing
 * @date   :   2021/5/25
 * Describe :
 */

typealias Block<T> = suspend (CoroutineScope) -> T
typealias Error = suspend (Exception) -> Unit
typealias Cancel = suspend (Exception) -> Unit


open class BaseViewModel : ViewModel() {

    protected fun launch(block: Block<Unit>, error: Error? = null, cancel: Cancel? = null, showErrorToast: Boolean = true): Job {
        return viewModelScope.launch {
            try {
                block.invoke(this)
            } catch (e: Exception) {
                when (e) {
                    is CancellationException -> {
                        // TODO: 2021/5/25 这里什么时候执行
                        cancel?.invoke(e)
                    }
                    else -> {
                        onError(e, showErrorToast)
                        error?.invoke(e)
                    }
                }
            }
        }

    }

    private fun onError(e: Exception, showErrorToast: Boolean) {
        when (e) {
            is ApiException -> {
                when (e.code) {
                    1000, 1001, 1007, 1003 -> {
                        // TODO: 2021/5/25 发送广播 ，弹toast
                        ToastUtils.showShort(e.message)
                    }
                    else -> {
                        // 其他错误
                        if (showErrorToast) {
                            ToastUtils.showShort(e.message)
                        }
                    }
                }
                Log.e("onError", e.message)
            }
            // 网络请求失败
            is ConnectException, is SocketTimeoutException, is UnknownHostException, is HttpException -> {
                if (showErrorToast) {
                    ToastUtils.showShort("获取数据失败,请先检查网络哦")
                    Log.e("onError", "ConnectException,SocketTimeoutException,UnknownHostException,HttpException")

                }
            }
            is JsonParseException -> {
                if (showErrorToast) {
                    ToastUtils.showShort("数据解析错误")
                    Log.e("onError", "数据解析错误${e.message}")

                }
            }
            // 其他错误
            else -> {
                if (showErrorToast) {
                    ToastUtils.showShort(e.message ?: return)
                    Log.e("onError",e.message ?: return)
                }
            }
        }
    }
}