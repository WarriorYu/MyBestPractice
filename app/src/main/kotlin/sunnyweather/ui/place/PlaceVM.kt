package com.example.mybestpractice.kotlin.sunnyweather.ui.place

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import com.example.mybestpractice.kotlin.mycoroutineretrofit.base.BaseViewModel
import com.example.mybestpractice.kotlin.sunnyweather.Place
import com.example.mybestpractice.kotlin.sunnyweather.Repository

/**
 * @author   :   yuxibing
 * @date   :   2021/5/25
 * Describe :
 */
class PlaceVM : BaseViewModel() {

    val placeLiveData = MutableLiveData<MutableList<Place>>()

    val placeList = ArrayList<Place>()

    fun searchPlaces(query: String) {
        launch(block = {
//            placeLiveData.value =
        })
    }
}