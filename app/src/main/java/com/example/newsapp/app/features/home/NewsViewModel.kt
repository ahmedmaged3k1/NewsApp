package com.example.newsapp.app.features.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.newsapp.domain.useCases.NewsUseCase
import com.example.newsapp.entities.News

class NewsViewModel : ViewModel() {
    val newsList = MutableLiveData<ArrayList<News>>()
    private val newsUseCase = NewsUseCase()
    suspend fun getAllArticles(searchQuery: String) {
        newsList.postValue(ArrayList(newsUseCase.getAllArticles(searchQuery)))
    }

    fun changeArticleStatus(position: Int) {
        if (position==-1)return
        val copy = newsList.value?.get(position)?.copy(seen = 1)
        newsList.value!![position] = copy!!
        val map = newsList.value?.map { it }
        newsList.value = ArrayList(map)
    }
}