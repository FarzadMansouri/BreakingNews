package com.fm.forecastweather.repository

import com.fm.forecastweather.network.BaseResponse
import javax.inject.Inject

class WeatherRepository @Inject constructor() : BaseResponse() {


    public suspend fun getWeather(location: String) = safeApi {

    }

}