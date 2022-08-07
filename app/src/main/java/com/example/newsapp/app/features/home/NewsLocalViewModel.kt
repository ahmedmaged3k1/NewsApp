package com.example.newsapp.app.features.home

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.newsapp.domain.useCases.NewsLocalUseCase
import com.example.newsapp.entities.News

class NewsLocalViewModel (application: Application) : AndroidViewModel(application) {
    private val newsLocalUseCae = NewsLocalUseCase(application)
     val newsList  = MutableLiveData<List<News>>()
    suspend fun getArticles(){
        newsList.postValue(newsLocalUseCae.getAllArticles())

    }
}