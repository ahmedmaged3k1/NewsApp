package com.example.newsapp.domain.core.network

import com.example.newsapp.domain.dataSource.remoteDataSource.NewsApiService
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.experimental.CoroutineCallAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitInstance {


    companion object {
        private val retrofitBuilder =
            Retrofit.Builder().baseUrl(Credentials.baseUrl)
                . addCallAdapterFactory(CoroutineCallAdapterFactory())
                .addConverterFactory(GsonConverterFactory.create())
        private val retrofit: Retrofit = retrofitBuilder.build()
        private val newsApi: NewsApiService = retrofit.create(NewsApiService::class.java)
        fun getNewsApi(): NewsApiService {
            return newsApi
        }
    }


}