package com.fm.news.domain.usecase

import com.fm.news.db.FavoriteDao
import com.fm.news.db.FavoriteDatabase
import com.fm.news.domain.repository.CommonRepository
import com.fm.news.model.Article
import com.fm.news.model.News
import com.fm.news.network.ApiClient
import com.fm.news.network.BaseResponse
import com.fm.news.network.Result
import com.fm.news.utils.Constant
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class CommonUseCase @Inject constructor(
    private val apiClient: ApiClient,
    private val favoriteDao: FavoriteDao
) :
    CommonRepository, BaseResponse() {
    override suspend fun getNews(query: String): Flow<Result<News>> =
        flow {
            emit(safeApi {
                apiClient.getNews(query, Constant.API_KEY, 1, Constant.PAGE_SIZE)
            })
        }

    override fun addFavorite(article: Article) =
        favoriteDao.addToFavorite(article)

    override fun isFavorite(title: String): Boolean = favoriteDao.isFavorite(title)
    override fun removeFavorite(title: String) = favoriteDao.removeFavorite(title)
    override suspend fun getAllFavorite(): Flow<List<Article>> = flow {
        emit(favoriteDao.getAllData())
    }
}