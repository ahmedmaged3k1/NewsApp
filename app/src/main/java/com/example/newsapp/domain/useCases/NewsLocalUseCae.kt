package com.example.newsapp.domain.useCases

import android.content.ContentValues
import android.content.Context
import android.util.Log
import com.example.newsapp.domain.dataSource.localDataSource.NewsLocalDataSource
import com.example.newsapp.entities.News

class NewsLocalUseCae(context: Context) {
    private val newsLocalDataSource = NewsLocalDataSource(context)
    suspend fun getAllArticles(searchQuery: String): List<News>? {
        newsLocalDataSource.insert(News("AS", "AS", "AS", "AS", "AS", "AS", "AS"))
        newsLocalDataSource.insert(News("Am", "AS", "AS", "AS", "AS", "AS", "AS"))
        newsLocalDataSource.insert(News("At", "AS", "AS", "AS", "AS", "AS", "AS"))

        Log.d(
            ContentValues.TAG,
            "getAllArticles: use case locally  ${newsLocalDataSource.getAllNews()?.size}"
        )
        return newsLocalDataSource.getAllNews()

    }

}