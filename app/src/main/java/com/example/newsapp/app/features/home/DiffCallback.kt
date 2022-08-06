package com.example.newsapp.app.features.home

import androidx.recyclerview.widget.DiffUtil

object DiffCallback {
    val DIFF_CALLBACK: DiffUtil.ItemCallback<String> = object : DiffUtil.ItemCallback<String>() {
        override fun areItemsTheSame(
            oldUser: String, newUser: String
        ): Boolean {
            return oldUser === newUser
        }


        override fun areContentsTheSame(
            oldUser: String, newUser: String
        ): Boolean {
            return oldUser == newUser
        }
    }
}