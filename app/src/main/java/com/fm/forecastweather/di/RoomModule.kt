package com.fm.forecastweather.di

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import com.fm.forecastweather.db.WeatherDao
import com.fm.forecastweather.db.WeatherDatabase
import com.fm.forecastweather.utils.Constant
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RoomModule {

    @Provides
    public fun provideDatabaseName()=Constant.WEATHER_DATABASE

    @Provides
    public fun provideWeatherDao(weatherDatabase: WeatherDatabase) = weatherDatabase
        .weatherDao()

    @Provides
    public fun providerWeatherDB(@ApplicationContext context: Context, dbname:String) = Room
        .databaseBuilder(context,WeatherDatabase::class.java,dbname).build()

}