package com.example.newsapp.domain.dataSource.remoteDataSource

import android.content.ContentValues
import android.service.controls.ControlsProviderService.TAG
import android.util.Log
import com.example.newsapp.domain.core.network.Credentials
import com.example.newsapp.domain.core.network.RetrofitInstance
import com.example.newsapp.domain.repositories.NewsRemoteRepository
import com.example.newsapp.entities.News
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class NewsRemoteDataSource : NewsRemoteRepository {

    private lateinit var newsList: List<News>

    override suspend fun getAllArticles(searchQuery: String): List<News> {
        withContext(Dispatchers.IO) {
            try {
                val response =
                    RetrofitInstance.getNewsApi().getAllArticles(searchQuery,Credentials.apiKey).body()?.articles ?: listOf(News("AS","AS","AS","AS","AS","AS","AS",1))
                newsList =response
                    Log.d(ContentValues.TAG, "getAllArticles: repo ${ newsList.size}")

            }
            catch (e: Exception) {
                Log.d(TAG, "getAllArticles: ${e.message}")
            }
        }

        return newsList
    }

}


/*

     response.enqueue(object : Callback<NewsResponse> {
                @RequiresApi(Build.VERSION_CODES.R)
                override fun onResponse(
                    call: Call<NewsResponse>,
                    response: Response<NewsResponse>
                ) {
                    Log.d(TAG, "onFailure: Response Size ${response.body()?.newsList?.size}")

                    newsList = response.body()?.newsList!!
                }

                @RequiresApi(Build.VERSION_CODES.R)
                override fun onFailure(call: Call<NewsResponse>, t: Throwable) {
                    Log.d(TAG, "onFailure: Response Errors")
                }


            })
 */