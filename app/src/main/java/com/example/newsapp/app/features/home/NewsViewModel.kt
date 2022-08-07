package com.example.newsapp.app.features.home

import android.content.ContentValues.TAG
import android.content.Context
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.newsapp.domain.useCases.NewsUseCase
import com.example.newsapp.entities.News

class NewsViewModel : ViewModel() {
     val newsList  = MutableLiveData<List<News>>()
    private val newsUseCase = NewsUseCase ()
    suspend fun getAllArticles(searchQuery: String){
        Log.d(TAG, "getAllArticles: view model ${ newsUseCase.getAllArticles(searchQuery).size}")
        Log.d(TAG, "getAllArticles: view model author ${ newsUseCase.getAllArticles(searchQuery).get(1).author}")
        Log.d(TAG, "getAllArticles: view model description  ${ newsUseCase.getAllArticles(searchQuery).get(1).description}")
        newsList.postValue(newsUseCase.getAllArticles(searchQuery))
    }
}