package com.fm.news.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.fm.news.model.Article
import com.fm.news.utils.Constant

@Database(entities = [Article::class], version = Constant.DATABASE_VERSION)
abstract class FavoriteDatabase : RoomDatabase() {

    abstract fun favoriteDao(): FavoriteDao

    companion object {
        private var INSTANCE: FavoriteDatabase? = null

        fun getDatabase(context: Context): FavoriteDatabase {
            if (INSTANCE == null) {
                synchronized(this) {
                    INSTANCE = buildDatabase(context)
                }
            }
            // Return database.
            return INSTANCE!!
        }

        private fun buildDatabase(context: Context): FavoriteDatabase {
            return Room.databaseBuilder(
                context.applicationContext,
                FavoriteDatabase::class.java,
                Constant.FAV_DATABASE
            ).fallbackToDestructiveMigration()
                .allowMainThreadQueries()
                .build()
        }
    }


}

