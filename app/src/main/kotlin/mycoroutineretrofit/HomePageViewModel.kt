package com.example.mybestpractice.kotlin.mycoroutineretrofit

import androidx.lifecycle.ViewModel

/**
 * @author   :   yuxibing
 * @date   :   2021/5/28
 * Describe :
 */
class HomePageViewModel :ViewModel(){

    fun getBanner() = HomeRepository.getBanner()
}