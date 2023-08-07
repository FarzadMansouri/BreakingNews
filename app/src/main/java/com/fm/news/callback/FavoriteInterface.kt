package com.fm.news.callback

import com.fm.news.model.Article
import com.fm.news.model.News

interface FavoriteInterface {

    fun addToFavorite(article: Article)
}