package com.example.newsapp.domain.useCases

import android.content.ContentValues
import android.content.Context
import android.util.Log
import com.example.newsapp.domain.dataSource.localDataSource.NewsLocalDataSource
import com.example.newsapp.domain.dataSource.remoteDataSource.NewsRemoteDataSource
import com.example.newsapp.entities.News

class NewsUseCase() {

     private val newsRemoteDataSource = NewsRemoteDataSource ()

    suspend fun getAllArticles (searchQuery: String) : List<News>{
        //Log.d(ContentValues.TAG, "getAllArticles: use case ${ newsRemoteDataSource.getAllArticles(searchQuery).size}")

        return newsRemoteDataSource.getAllArticles(searchQuery)

    }

}