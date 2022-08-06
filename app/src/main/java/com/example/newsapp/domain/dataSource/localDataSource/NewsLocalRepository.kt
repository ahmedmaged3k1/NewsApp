package com.example.newsapp.domain.dataSource.localDataSource

import androidx.lifecycle.LiveData

import com.example.newsapp.entities.News

interface NewsLocalRepository {

    suspend fun insert(news: News)
    suspend fun update(news: News)
    suspend fun delete (news: News)
    fun getAllNews(): LiveData<List<News>>?
}