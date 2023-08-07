package com.fm.news.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import com.fm.news.callback.FavoriteInterface
import com.fm.news.databinding.NewsRowRecyclerBinding
import com.fm.news.model.Article
import com.fm.news.viewmodel.MainViewModel

class NewsAdapter(private val vm:MainViewModel,private val favoriteInterface:FavoriteInterface) :
    androidx.recyclerview.widget.ListAdapter<Article, NewsViewHolder>(NewsDiffUtils) {


    private lateinit var binding: NewsRowRecyclerBinding
    private lateinit var newsList:List<Article>

    fun newsList(newsList: List<Article>){
        this.newsList=newsList
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        binding = NewsRowRecyclerBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return NewsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        holder.bind(vm,favoriteInterface,holder.itemView.context, getItem(position))

    }

}

object NewsDiffUtils :DiffUtil.ItemCallback<Article>(){
    override fun areItemsTheSame(oldItem: Article, newItem: Article): Boolean {
        return oldItem.title==newItem.title
    }

    override fun areContentsTheSame(oldItem: Article, newItem: Article): Boolean {
        return oldItem==newItem
    }

}