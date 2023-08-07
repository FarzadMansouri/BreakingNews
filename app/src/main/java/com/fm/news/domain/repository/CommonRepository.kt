package com.fm.news.domain.repository

import com.fm.news.model.Article
import com.fm.news.model.News
import kotlinx.coroutines.flow.Flow

interface CommonRepository {
    fun addFavorite(article: Article)
    fun isFavorite(title: String): Boolean
    fun removeFavorite(title: String)
    suspend fun getAllFavorite(): Flow<List<Article>>
    suspend fun getNews(query:String):Flow<com.fm.news.network.Result<News>>

}