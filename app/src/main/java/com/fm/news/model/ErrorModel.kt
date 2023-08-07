package com.fm.news.model

import okhttp3.ResponseBody

data class ErrorModel(
    private val isNetworkError:Boolean,
    private val errorBody: ResponseBody,
    private val errorCode: Int,
)
