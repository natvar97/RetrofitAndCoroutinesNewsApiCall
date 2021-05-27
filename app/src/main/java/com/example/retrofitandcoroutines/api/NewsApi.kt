package com.example.retrofitandcoroutines.api

import com.example.retrofitandcoroutines.model.NewsEntity
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApi {

    @GET("top-headlines")
    suspend fun getNewsTopHeadlines(
        @Query("country") country : String,
        @Query("category") category : String,
        @Query("apiKey") apiKey : String
    ) : NewsEntity


}