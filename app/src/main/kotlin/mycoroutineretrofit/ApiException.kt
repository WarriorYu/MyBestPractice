package com.example.mybestpractice.kotlin.mycoroutineretrofit

import java.lang.RuntimeException

/**
 * @author   :   yuxibing
 * @date   :   2021/5/25
 * Describe : 自定义异常
 */
class ApiException(val code: Int, override val message: String) : RuntimeException(message) {
}