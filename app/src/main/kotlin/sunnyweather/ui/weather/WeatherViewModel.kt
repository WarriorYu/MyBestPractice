package com.example.mybestpractice.kotlin.sunnyweather.ui.weather

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mybestpractice.kotlin.sunnyweather.Location
import com.example.mybestpractice.kotlin.sunnyweather.Repository

/**
 * @author   :   yuxibing
 * @date   :   2021/5/21
 * Describe :
 */
class WeatherViewModel : ViewModel() {

    private val locationLiveData = MutableLiveData<Location>()

    var locationLng = ""
    var locationLat = ""
    var placeName = ""

    fun refreshWeather(lng: String, lat: String) {
        locationLiveData.value = Location(lng, lat)
    }

    val weatherLiveData = Transformations.switchMap(locationLiveData) { location ->
        viewModelScope
        Repository.refreshWeather(location.lng, location.lat)
    }
}