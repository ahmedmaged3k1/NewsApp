package com.example.newsapp.domain.repositories

import com.example.newsapp.entities.News

interface NewsLocalRepository {

    suspend fun insert(news: News)
    suspend fun update(news: News)
    suspend fun delete(news: News)
    suspend fun getAllNews(): List<News>?
}