package com.example.newsapp.entities

data class NewsResponse(
    val articles: List<News>,
    val status: String,
    val totalResults: Int
)
