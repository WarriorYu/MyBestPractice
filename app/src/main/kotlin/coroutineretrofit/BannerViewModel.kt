package com.example.mybestpractice.kotlin.CoroutineRetrofit

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

/**
 * @author   :   yuxibing
 * @date   :   2021/5/24
 * Describe :
 */

class BannerViewModel : ViewModel(){
    val mBannerLiveData = MutableLiveData<List<Banner>>()
    fun getBanner() {
        viewModelScope.launch {
            val res = apiCall { Api.get().getBanner() }
            if (res.errorCode == 0 && res.data != null) {
                mBannerLiveData.postValue(res.data!!)
            } else {
                // 报错
            }
        }
    }
}
