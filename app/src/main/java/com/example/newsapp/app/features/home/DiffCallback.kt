package com.example.newsapp.app.features.home

import androidx.recyclerview.widget.DiffUtil
import com.example.newsapp.entities.News

object DiffCallback {
    val DIFF_CALLBACK: DiffUtil.ItemCallback<News> = object : DiffUtil.ItemCallback<News>() {
        override fun areItemsTheSame(oldItem: News, newItem: News): Boolean {
            return oldItem === newItem

        }


        override fun areContentsTheSame(oldItem: News, newItem: News): Boolean {
            return oldItem.id == newItem.id &&
                    oldItem.description == newItem.description &&
                    oldItem.url == newItem.url &&
                    oldItem.content == newItem.content &&
                    oldItem.urlToImage == newItem.urlToImage &&
                    oldItem.author == newItem.author &&
                    oldItem.title == newItem.title
        }
    }
}