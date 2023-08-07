package com.fm.news.network

import com.fm.news.model.News
import kotlinx.coroutines.flow.Flow
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiClient {

    @GET("everything")
    suspend fun getNews(@Query("q")q:String,
                        @Query("apikey")apikey:String,
                        @Query("page")page:Int,
                        @Query("pageSize")pageSize:Int):News

}