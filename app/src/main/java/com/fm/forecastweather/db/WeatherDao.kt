package com.fm.forecastweather.db

import androidx.room.Dao
import androidx.room.Insert

@Dao
interface WeatherDao {


    @Insert
    public fun insertLastCondition()

}