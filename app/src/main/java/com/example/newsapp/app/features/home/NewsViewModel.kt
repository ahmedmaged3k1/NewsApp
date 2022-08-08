package com.example.newsapp.app.features.home

import android.content.ContentValues.TAG
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.newsapp.domain.useCases.NewsUseCase
import com.example.newsapp.entities.News

class NewsViewModel : ViewModel() {
    val newsList = MutableLiveData<List<News>>()
    private val newsUseCase = NewsUseCase()
    suspend fun getAllArticles(searchQuery: String) {
        newsList.postValue(newsUseCase.getAllArticles(searchQuery))
    }
}