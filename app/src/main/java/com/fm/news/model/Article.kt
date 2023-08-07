package com.fm.news.model

import androidx.room.*
import com.fm.news.utils.Constant

@Entity(tableName = Constant.FAV_TABLE)
data class Article(
    @PrimaryKey(autoGenerate = true)
    val id:Int,
    val author: String?="",
    val content: String?="",
    val description: String?="",
    val publishedAt: String?="",
    @Embedded
    val source: Source,
    val title: String?="",
    val url: String?="",
    val urlToImage: String?=""
)