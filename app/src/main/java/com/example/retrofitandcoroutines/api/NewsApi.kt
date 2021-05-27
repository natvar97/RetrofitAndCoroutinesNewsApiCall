package com.example.retrofitandcoroutines.api

import com.example.retrofitandcoroutines.model.NewsEntity
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApi {
    /*
    apiKey = f0ff90e809ef4848885fad9b2250cd17

    BASE_URL = https://newsapi.org/v2/

    EXTRA PART =  "top-headlines?country=us&category=business&apiKey=f0ff90e809ef4848885fad9b2250cd17"


     */

    @GET("top-headlines")
    suspend fun getNewsTopHeadlines(
        @Query("sources") category : String,
        @Query("apiKey") apiKey : String
    ) : NewsEntity


}