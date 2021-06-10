package com.example.mybestpractice.kotlin.mycoroutineretrofit.base

import android.content.pm.ActivityInfo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.viewbinding.ViewBinding
import com.example.mybestpractice.kotlin.sunnyweather.ui.place.PlaceViewModel

abstract class BaseVmActivity<VB : ViewBinding> : AppCompatActivity() {

    protected lateinit  var mBinding: VB

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = getDataBinding()
        setContentView(mBinding.root)
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT


        initView(savedInstanceState)
        initData()
    }

    /**
     * 初始化DataBinding
     */
    abstract fun getDataBinding(): VB


    /**
     * 初始化View相关
     */
    abstract fun initView(savedInstanceState: Bundle?)

    /**
     * 初始化data相关
     */
    open fun initData() {}


}