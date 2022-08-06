package com.example.newsapp.domain.dataSource.core.network

import com.example.newsapp.domain.dataSource.remoteDataSource.NewsApiService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitInstance {

    companion object {
        private val retrofitBuilder =
            Retrofit.Builder().addConverterFactory(GsonConverterFactory.create())
        private val retrofit: Retrofit = retrofitBuilder.build()
        private val newsApi: NewsApiService = retrofit.create(NewsApiService::class.java)
        fun getNewsApi(): NewsApiService {
            return newsApi
        }
    }


}