package com.example.retrofitandcoroutines.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.retrofitandcoroutines.repository.NewsApiRepository

class ViewModelFactory : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(NewsViewModel::class.java)) {
            return NewsViewModel(NewsApiRepository()) as T
        }
        throw IllegalArgumentException("Unknown View Model class found")
    }
}