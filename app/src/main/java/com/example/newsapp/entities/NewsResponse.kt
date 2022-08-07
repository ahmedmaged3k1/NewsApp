package com.example.newsapp.entities

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class NewsResponse(
    val articles: List<News>,
    val status: String,
    val totalResults: Int
)
