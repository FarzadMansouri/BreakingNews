package com.fm.forecastweather.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.fm.forecastweather.model.Weather
import com.fm.forecastweather.utils.Constant

@Database(entities = [Weather::class], version = Constant.DATABASE_VERSION)
abstract class WeatherDatabase : RoomDatabase() {

    public abstract fun weatherDao(): WeatherDao

    private var INSTANCE: WeatherDatabase? = null


    public fun database(context: Context) = synchronized(this) {
        var tempInstance = INSTANCE
        if(tempInstance==null) {
           INSTANCE=Room
                .databaseBuilder(context, WeatherDatabase::class.java, Constant.WEATHER_DATABASE)
                .fallbackToDestructiveMigration()
                .build()
        }

    }
}
