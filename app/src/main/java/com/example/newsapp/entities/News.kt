package com.example.newsapp.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity
data class News(
    @SerializedName("author") var author: String,
    @SerializedName("title") var title: String,
    @SerializedName("description") var description: String,
    @SerializedName("url") var url: String,

    @SerializedName("urlToImage") var urlToImage: String,
    @SerializedName("publishedAt") var publishedAt: String,
    @SerializedName("content") var content: String,
    @PrimaryKey(autoGenerate = true) var id : Int

)