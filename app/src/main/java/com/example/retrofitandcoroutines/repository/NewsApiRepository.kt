package com.example.retrofitandcoroutines.repository

import androidx.annotation.WorkerThread
import com.example.retrofitandcoroutines.api.RetrofitBuilder
import com.example.retrofitandcoroutines.utils.Constants

class NewsApiRepository() {

    @WorkerThread
    suspend fun getNewsTopHeadlines() = RetrofitBuilder.apiService
        .getNewsTopHeadlines(
            Constants.COUNTRY,
            Constants.CATEGORY,
            Constants.API_KEY
        )
}