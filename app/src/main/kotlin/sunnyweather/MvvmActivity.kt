package com.example.mybestpractice.kotlin.sunnyweather

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.example.mybestpractice.R
import com.example.mybestpractice.kotlin.CoroutineRetrofit.BannerViewModel
import com.example.mybestpractice.kotlin.Utils
import com.yu.common.ActivityManager

class MvvmActivity : AppCompatActivity() {
    private val viewModel:BannerViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mvvm2)

//        lifecycleScope.launchWhenCreated {
//
//        }



//        val create = ServiceCreator.create(GitHubService::class.java)
//        val create1 = ServiceCreator.create<GitHubService>()

        //测试Activity管理栈
        val topActivity = ActivityManager.instance.topActivity
        if (topActivity != null) {
            Utils.toast(topActivity.localClassName)
        }


    }
}