package com.example.newsapp.domain.dataSource.localDataSource

import android.content.Context
import androidx.lifecycle.LiveData
import com.example.newsapp.domain.dataSource.localDataSource.room.NewsDatabase
import com.example.newsapp.domain.repositories.NewsLocalRepository
import com.example.newsapp.entities.News
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class NewsLocalDataSource(context: Context) : NewsLocalRepository {
    private var newsDatabase: NewsDatabase? = NewsDatabase.getInstance(context)

    companion object {
        private var INSTANCE: NewsLocalDataSource? = null
        fun getInstance(context: Context): NewsLocalDataSource? {
            if (INSTANCE == null) {
                INSTANCE = NewsLocalDataSource(context)
            }
            return INSTANCE
        }
    }

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

    override suspend fun getAllNews(): LiveData<List<News>>? {
        return newsDatabase?.newsDao?.getAllNews()
    }


}


