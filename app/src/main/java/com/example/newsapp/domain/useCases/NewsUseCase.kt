package com.example.newsapp.domain.useCases

import com.example.newsapp.data.dataSource.remoteDataSource.NewsRemoteDataSource
import com.example.newsapp.entities.News

class NewsUseCase {

    private val newsRemoteDataSource = NewsRemoteDataSource()
    suspend fun getAllArticles(searchQuery: String): List<News> {
        //Log.d(ContentValues.TAG, "getAllArticles: use case ${ newsRemoteDataSource.getAllArticles(searchQuery).size}")

        return newsRemoteDataSource.getAllArticles(searchQuery)

    }

}