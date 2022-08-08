package com.example.newsapp.domain.dataSource.localDataSource.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.newsapp.entities.News

@Database(entities = [News::class], version = 7, exportSchema = false)
abstract class NewsDatabase : RoomDatabase() {

    abstract val newsDao: NewsDao

    companion object {

        @Volatile
        private var INSTANCE: NewsDatabase? = null

        fun getInstance(context: Context): NewsDatabase {
            synchronized(this) {
                var instance = INSTANCE
                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        NewsDatabase::class.java,
                        "news_database"
                    )
                        .fallbackToDestructiveMigration()
                        .build()
                    INSTANCE = instance
                }
                return instance
            }

        }
    }

}