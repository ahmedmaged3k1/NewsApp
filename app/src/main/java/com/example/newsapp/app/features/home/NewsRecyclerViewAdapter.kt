package com.example.newsapp.app.features.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.newsapp.databinding.NewsItemBinding
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
    ListAdapter<News, NewsRecyclerViewAdapter.NewsViewHolder>(diffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        return from(parent)
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        holder.onBindItemHolder(holder, position)


    }

    inner class NewsViewHolder  constructor(private val binding: NewsItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun onBindItemHolder(holder: NewsViewHolder, position: Int) {
            binding.authorName.text= getItem(position).author
            Glide.with(holder.itemView.context).load(getItem(position).urlToImage).into(binding.newImage)
            binding.description.text=getItem(position).description

        }






    }
    private fun from(parent: ViewGroup): NewsViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = NewsItemBinding.inflate(inflater, parent, false)
        return NewsViewHolder(binding)
    }



}

