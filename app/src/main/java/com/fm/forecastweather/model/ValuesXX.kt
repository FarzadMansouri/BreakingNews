package com.fm.forecastweather.model

data class ValuesXX(
    val cloudBase: Any,
    val cloudCeiling: Any,
    val cloudCover: Double,
    val dewPoint: Double,
    val freezingRainIntensity: Int,
    val humidity: Double,
    val precipitationProbability: Int,
    val pressureSurfaceLevel: Double,
    val rainIntensity: Int,
    val sleetIntensity: Int,
    val snowIntensity: Int,
    val temperature: Double,
    val temperatureApparent: Double,
    val uvHealthConcern: Int,
    val uvIndex: Int,
    val visibility: Double,
    val weatherCode: Int,
    val windDirection: Double,
    val windGust: Double,
    val windSpeed: Double
)