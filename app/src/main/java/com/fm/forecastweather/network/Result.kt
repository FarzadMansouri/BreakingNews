package com.fm.forecastweather.network

import okhttp3.RequestBody
import okhttp3.ResponseBody

sealed class Result<out R> {
    data class Success<R>(val value: R) : Result<R>()
    data class Failure(
        val isNetworkError: Boolean? = false,
        val errorBody: ResponseBody? = null,
        val errorCode: Int? = 0

    ) : Result<Nothing>()
}