package com.example.newsapp.app.features.home

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.newsapp.R
import com.example.newsapp.databinding.NewsItemBinding
import com.example.newsapp.entities.News


val diffCallback = object : DiffUtil.ItemCallback<News>() {
    override fun areItemsTheSame(oldItem: News, newItem: News): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: News, newItem: News): Boolean {
        return oldItem.seen == newItem.seen



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
            if(getItem(position).seen==1)
            {
                binding.seen.setImageResource(R.drawable.ic_baseline_remove_red_eye_24)
                binding.constraintLayout.setBackgroundColor(Color.RED)

            }

        }






    }
    private fun from(parent: ViewGroup): NewsViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = NewsItemBinding.inflate(inflater, parent, false)
        return NewsViewHolder(binding)
    }



}

