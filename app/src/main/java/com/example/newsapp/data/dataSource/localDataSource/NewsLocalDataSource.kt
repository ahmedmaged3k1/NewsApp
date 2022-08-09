package com.example.newsapp.data.dataSource.localDataSource

import android.content.Context
import com.example.newsapp.data.dataSource.localDataSource.room.NewsDatabase
import com.example.newsapp.domain.repositories.NewsLocalRepository
import com.example.newsapp.entities.News
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class NewsLocalDataSource(context: Context) : NewsLocalRepository {
    private var newsDatabase: NewsDatabase? = NewsDatabase.getInstance(context)
    override suspend fun insert(news: News) {
        withContext(Dispatchers.IO) {
            newsDatabase?.newsDao?.insert(news)
        }
    }

    override suspend fun update(news: News) {
        withContext(Dispatchers.IO) {
            newsDatabase?.newsDao?.update(news)
        }
    }


    override suspend fun delete(news: News) {
        withContext(Dispatchers.IO) {
            newsDatabase?.newsDao?.delete(news)
        }


    }

    override suspend fun getAllNews(): List<News>? {
        return newsDatabase?.newsDao?.getAllNews()
    }


}


