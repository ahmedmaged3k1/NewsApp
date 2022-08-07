package com.example.newsapp.domain.repositories

import com.example.newsapp.entities.News

interface NewsRemoteRepository {
   suspend fun getAllArticles (searchQuery: String) : List<News>
}