package com.example.newsapp.domain.dataSource.remoteDataSource

import android.os.Build
import android.service.controls.ControlsProviderService.TAG
import android.util.Log
import androidx.annotation.RequiresApi
import com.example.newsapp.domain.core.network.RetrofitInstance
import com.example.newsapp.domain.core.network.Credentials
import com.example.newsapp.domain.repositories.NewsRemoteRepository
import com.example.newsapp.entities.News
import com.example.newsapp.entities.NewsResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NewsRemoteDataSource : NewsRemoteRepository {

    lateinit var newsList: List<News>

    override fun getAllArticles(): List<News> {
        val response = RetrofitInstance.getNewsApi().getAllArticles(Credentials.apiKey)
        response.enqueue(object : Callback<NewsResponse> {
            @RequiresApi(Build.VERSION_CODES.R)
            override fun onResponse(call: Call<NewsResponse>, response: Response<NewsResponse>) {
                Log.d(TAG, "onFailure: Response Size ${response.body()?.newsList?.size}")

                newsList = response.body()?.newsList!!
            }

            @RequiresApi(Build.VERSION_CODES.R)
            override fun onFailure(call: Call<NewsResponse>, t: Throwable) {
                Log.d(TAG, "onFailure: Response Errors")
            }


        })
        return newsList
    }
}