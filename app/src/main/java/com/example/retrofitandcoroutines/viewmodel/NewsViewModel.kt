package com.example.retrofitandcoroutines.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.retrofitandcoroutines.model.Articles
import com.example.retrofitandcoroutines.model.NewsEntity
import com.example.retrofitandcoroutines.repository.NewsApiRepository
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch

class NewsViewModel(
    private val repository: NewsApiRepository
) : ViewModel() {

    private val newsList = MutableLiveData<NewsEntity>()

    init {
        fetchNews()
    }

    private fun fetchNews() {
        viewModelScope.launch {
            try {
                coroutineScope {
                    val news = async { repository.getNewsTopHeadlines() }
                    newsList.postValue(news.await())
                }
            } catch (e: Exception) {
                emptyList<Articles>()
            }
        }
    }

    fun getAllNews() : LiveData<NewsEntity> {
        return newsList
    }

}