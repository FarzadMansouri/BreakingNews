package com.fm.news.db

import android.net.wifi.WifiManager.LocalOnlyHotspotCallback
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.fm.news.model.Article
import com.fm.news.utils.Constant

@Dao
interface FavoriteDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
     fun addToFavorite(article: Article)

    @Query("SELECT * FROM ${Constant.FAV_TABLE}")
      fun getAllData(): List<Article>

    @Query("SELECT EXISTS (SELECT 1 FROM ${Constant.FAV_TABLE} WHERE title = :title)")
     fun isFavorite(title: String): Boolean

    @Query("DELETE FROM ${Constant.FAV_TABLE} WHERE title = :title")
     fun removeFavorite(title: String)

}