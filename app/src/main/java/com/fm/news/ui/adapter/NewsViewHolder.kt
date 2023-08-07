package com.fm.news.ui.adapter

import android.content.Context
import android.text.method.LinkMovementMethod
import androidx.appcompat.widget.AppCompatImageButton
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.fm.news.R
import com.fm.news.callback.FavoriteInterface
import com.fm.news.databinding.NewsRowRecyclerBinding
import com.fm.news.model.Article
import com.fm.news.viewmodel.MainViewModel


class NewsViewHolder(viewItem: NewsRowRecyclerBinding) :
    RecyclerView.ViewHolder(viewItem.root) {

    private val title: AppCompatTextView = viewItem.txtTitle
    private val description: AppCompatTextView = viewItem.txtDesc
    private val author: AppCompatTextView = viewItem.txtAuthor
    private val content: AppCompatTextView = viewItem.txtContent
    private val url: AppCompatTextView = viewItem.txtUrl
    private val publishedAt: AppCompatTextView = viewItem.txtPublish
    private val img: AppCompatImageView = viewItem.imageNews
    private val favorite: AppCompatImageButton = viewItem.btnFavorite


    fun bind(
        vm: MainViewModel,
        favoriteInterface: FavoriteInterface,
        ctx: Context,
        article: Article
    ) {


        title.text = article.title
        description.text = article.description
        content.text = article.content
        url.text = article.url
        url.movementMethod = LinkMovementMethod.getInstance()
        author.text = article.author
        publishedAt.text = article.publishedAt

        Glide.with(ctx).load(article.urlToImage).centerCrop()
            .placeholder(R.drawable.baseline_broken_image).into(img)

        val title = article.title
        val isCurrentlyFavorite = vm.isFavorite(title!!)
        if (isCurrentlyFavorite) {
            favorite.setImageResource(R.drawable.d0_round_bookmark)
        } else {
            favorite.setImageResource(R.drawable.round_bookmark_border)
        }

        favorite.setOnClickListener {
            favoriteInterface.addToFavorite(article)
            if (isCurrentlyFavorite) {
                favorite.setImageResource(R.drawable.round_bookmark_border)
            } else {
                favorite.setImageResource(R.drawable.d0_round_bookmark)
            }
        }

    }

}