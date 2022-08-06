package com.example.newsapp.entities

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class NewsResponse {
    @SerializedName("articles")
    @Expose
    var  newsList : List<News> = listOf()


}
