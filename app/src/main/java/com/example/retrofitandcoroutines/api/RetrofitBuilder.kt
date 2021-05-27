package com.example.retrofitandcoroutines.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitBuilder {

    const val BASE_URL = "https://newsapi.org/v2/"
    const val API_KEY = "f0ff90e809ef4848885fad9b2250cd17"
    const val SOURCES = "techcrunch"
    const val CATEGORY = "business"
    const val COUNTRY = "in"

    fun getInstance() = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val apiService: NewsApi = getInstance().create(NewsApi::class.java)

}