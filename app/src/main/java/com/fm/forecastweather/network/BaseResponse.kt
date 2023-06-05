package com.fm.forecastweather.network

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.HttpException

abstract class BaseResponse {
    suspend fun <T> safeApi(api: suspend () -> T) {
        return withContext(Dispatchers.IO) {
            try {
                Result.Success(api.invoke())

            } catch (throwable: Throwable) {
                when (throwable) {
                    is HttpException -> {
                        Result.Failure(
                            false,
                            throwable.response()?.errorBody(),
                            throwable.response()?.code()
                        )
                    }
                    else -> {
                        Result.Failure(true, null, null);
                    }
                }
            }
        }
    }
}