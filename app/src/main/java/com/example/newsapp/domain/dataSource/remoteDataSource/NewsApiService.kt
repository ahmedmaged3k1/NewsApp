package com.example.newsapp.domain.dataSource.remoteDataSource

import com.example.newsapp.entities.NewsResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query


interface NewsApiService {

    @GET("everything?q=bitcoin&")
    fun getAllArticles(@Query("apiKey") key: String): Call<NewsResponse>

}