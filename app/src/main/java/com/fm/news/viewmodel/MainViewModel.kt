package com.fm.news.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fm.news.domain.usecase.CommonUseCase
import com.fm.news.model.Article
import com.fm.news.model.ErrorModel
import com.fm.news.model.News
import com.fm.news.network.Result
import com.fm.news.utils.Constant
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject
@HiltViewModel
class MainViewModel@Inject constructor(private val commonUseCase: CommonUseCase) :
    ViewModel() {

    private val _newsLv: MutableLiveData<News> = MutableLiveData()
    val newsLv: LiveData<News> = _newsLv

    private val _errorLv: MutableLiveData<ErrorModel> =
        MutableLiveData()
    val errorLv: LiveData<ErrorModel> = _errorLv

    private val _favLvList: MutableLiveData<List<Article>> = MutableLiveData()
    val favLvList: LiveData<List<Article>> = _favLvList

    fun getNews(q: String) = viewModelScope.launch {

        commonUseCase.getNews(q).collect {
            when (it) {
                is Result.Success -> {

                    Log.d(Constant.TAG, "getNews: ${it.value}")
                    _newsLv.postValue(it.value!!)
                }
                is Result.Failure -> {
                    _errorLv.postValue(
                        ErrorModel(
                            it.isNetworkError!!,
                            it.errorBody!!,
                            it.errorCode!!
                        )
                    )
                }
            }
        }
    }

    public fun insertToFavorite(article: Article) {
        return commonUseCase.addFavorite(article)
    }

    fun getAllFav()=viewModelScope.launch {
          commonUseCase.getAllFavorite().collect{
              _favLvList.postValue(it)
          }
        }

    public fun removeFavorite(title:String) {
        return commonUseCase.removeFavorite(title)
    }

    public fun isFavorite(title: String): Boolean {
        return commonUseCase.isFavorite(title)
    }
}
