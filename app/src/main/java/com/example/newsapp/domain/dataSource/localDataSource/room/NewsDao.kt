package com.example.newsapp.domain.dataSource.localDataSource.room

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.newsapp.entities.News


@Dao
interface NewsDao {
    @Insert
    suspend fun  insert(news: News)

    @Update
    suspend fun update(news: News)

    @Delete
    suspend fun delete (news: News)


    @Query("SELECT * FROM  News ")
   suspend fun getAllNews(): List<News>?


}