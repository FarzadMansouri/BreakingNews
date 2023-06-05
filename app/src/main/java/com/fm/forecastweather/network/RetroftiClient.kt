package com.fm.forecastweather.network

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import java.util.concurrent.TimeUnit

object RetroftiClient {


    val client=OkHttpClient.Builder()
        .connectTimeout(15,TimeUnit.SECONDS)
        .writeTimeout(15,TimeUnit.SECONDS)
        .readTimeout(15,TimeUnit.SECONDS)
        .build()




    public fun<Api> makeRetrofit(api:Class<Api>){
        return Retrofit.Builder()
            .baseUrl()
    }



}