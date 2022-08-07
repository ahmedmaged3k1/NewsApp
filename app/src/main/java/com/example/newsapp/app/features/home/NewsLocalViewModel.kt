package com.example.newsapp.app.features.home

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.newsapp.domain.useCases.NewsLocalUseCae
import com.example.newsapp.entities.News

class NewsLocalViewModel (application: Application) : AndroidViewModel(application) {
    private val newsLocalUseCae = NewsLocalUseCae(application)
    val newsList  = MutableLiveData<List<News>>()
}