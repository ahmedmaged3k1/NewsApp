package com.example.newsapp.domain.dataSource.localDataSource.room

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.newsapp.entities.News


@Dao
interface NewsDao {
    @Insert
    fun insert(news: News)

    @Update
    fun update(news: News)

    @Delete
    fun delete (news: News)


    @Query("SELECT * FROM  News ")
    fun getAllNews(): LiveData<List<News>>?


}