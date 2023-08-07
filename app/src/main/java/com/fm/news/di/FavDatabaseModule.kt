package com.fm.news.di

import android.content.Context
import androidx.room.Room
import com.fm.news.db.FavoriteDao
import com.fm.news.db.FavoriteDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object FavDatabaseModule {

    @Provides
    @Singleton
    fun provideFavoriteDatabase(
        @ApplicationContext context: Context
    ): FavoriteDatabase =
        Room.databaseBuilder(context, FavoriteDatabase::class.java, "blog.db")
            .allowMainThreadQueries()
            .build()

    @Provides
    @Singleton
    fun provideFavoriteDao(database: FavoriteDatabase): FavoriteDao =
        database.favoriteDao()


}
