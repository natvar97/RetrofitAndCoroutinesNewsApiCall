package com.example.retrofitandcoroutines.repository

import androidx.annotation.WorkerThread
import com.example.retrofitandcoroutines.api.RetrofitBuilder

class NewsApiRepository() {

    @WorkerThread
    suspend fun getNewsTopHeadlines() = RetrofitBuilder.apiService
        .getNewsTopHeadlines(
            RetrofitBuilder.SOURCES,
            RetrofitBuilder.API_KEY
        )

}