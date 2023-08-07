package com.fm.news.utils

import android.content.Context
import android.opengl.Visibility
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.fm.news.ui.adapter.NewsAdapter

fun RecyclerView.fillRecycler(ctx: Context, adapter: NewsAdapter) {
    this.layoutManager = LinearLayoutManager(ctx, LinearLayoutManager.VERTICAL, false)
    this.adapter = adapter
}


fun View.show(status: Boolean) =
    if (status) this.visibility = View.VISIBLE else this.visibility = View.GONE
