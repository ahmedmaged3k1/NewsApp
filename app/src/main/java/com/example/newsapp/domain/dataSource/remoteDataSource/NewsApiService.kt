package com.example.newsapp.domain.dataSource.remoteDataSource

import com.example.newsapp.entities.NewsResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query


interface NewsApiService {

    @GET("everything")
   suspend fun getAllArticles(@Query("q") searchQuery: String,@Query("apiKey") key: String): Response<NewsResponse>

}