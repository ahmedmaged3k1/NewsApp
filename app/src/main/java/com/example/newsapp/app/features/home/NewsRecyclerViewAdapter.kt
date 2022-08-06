package com.example.newsapp.app.features.home

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.newsapp.entities.News


val diffCallback = object : DiffUtil.ItemCallback<News>() {
    override fun areItemsTheSame(oldItem: News, newItem: News): Boolean {
        return oldItem.title == newItem.title
    }

    override fun areContentsTheSame(oldItem: News, newItem: News): Boolean {
        return oldItem.author == newItem.author
                && oldItem.title == newItem.title
                && oldItem.description == newItem.description
                && oldItem.content == newItem.content
                && oldItem.url == newItem.url
                && oldItem.urlToImage == newItem.urlToImage
                && oldItem.publishedAt == newItem.publishedAt

    }


}

class NewsRecyclerViewAdapter :
    ListAdapter<News, NewsRecyclerViewAdapter.ViewHolder>(diffCallback) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBindItemHolder(holder, position)

    }

    inner class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {

        fun onBindItemHolder(holder: ViewHolder, position: Int) {

        }
    }


}