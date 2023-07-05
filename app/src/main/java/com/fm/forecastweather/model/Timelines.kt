package com.fm.forecastweather.model

data class Timelines(
    val daily: List<Daily>,
    val hourly: List<Hourly>,
    val minutely: List<Minutely>
)