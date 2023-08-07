package com.fm.news.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import javax.annotation.Nullable

data class Source(
    @ColumnInfo(name = "source_id")
    val id: String?="",
    val name: String?=""

)