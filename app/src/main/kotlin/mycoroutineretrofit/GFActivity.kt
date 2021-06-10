package com.example.mybestpractice.kotlin.mycoroutineretrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import com.example.mybestpractice.databinding.ActivityGFBinding
import com.example.mybestpractice.kotlin.mycoroutineretrofit.base.BaseVmActivity

class GFActivity : BaseVmActivity<ActivityGFBinding>() {
    private val homePageViewModel by viewModels<HomePageViewModel>()
    override fun getDataBinding(): ActivityGFBinding = ActivityGFBinding.inflate(layoutInflater)
    override fun initView(savedInstanceState: Bundle?) {

    }

    override fun initData() {
        super.initData()
        Log.e("网路请求", "开始加载")
        homePageViewModel.getBanner().observe(this) {
            if (it.isSuccess) {
                Log.e("网路请求", "结束加载")
                val dataList = it.getOrNull()
                if (dataList != null) {
                    Log.e("网路请求", "获取到数据")
                } else {
                    Log.e("网路请求", "获取数据为空")
                }
            } else {
                // 在这判断哪一类的Exception
                val exception = it.exceptionOrNull()
                if (exception is ApiException) {
                    Log.e("网路请求", "ApiException")
                } else {
                    Log.e("网路请求", "请求或者服务器错误")
                }
            }
        }
    }


}