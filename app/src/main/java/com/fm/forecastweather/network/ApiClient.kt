package com.fm.forecastweather.network

import com.fm.forecastweather.model.Weather
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiClient {

    @GET("/v4/weather/forecast")
    suspend fun getCurrentWeather(@Query("location")location:String,@Query("apikey")apikey:String):Weather

}