package com.fm.news.ui.favorite

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import com.fm.news.callback.FavoriteInterface
import com.fm.news.databinding.ActivityMainBinding
import com.fm.news.databinding.FavoriteFragmentBinding
import com.fm.news.databinding.HomeFragmentBinding
import com.fm.news.model.Article
import com.fm.news.ui.adapter.NewsAdapter
import com.fm.news.utils.fillRecycler
import com.fm.news.utils.show
import com.fm.news.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FavoriteFragment: Fragment(),FavoriteInterface {

    private lateinit var binding: FavoriteFragmentBinding
    private var adapter: NewsAdapter? = null

    private val viewModel:MainViewModel by activityViewModels()



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        adapter = NewsAdapter(viewModel,this)
        binding.favRecycler.fillRecycler(activity!!, adapter!!)


        viewModel.getAllFav()

        viewModel.favLvList.observe(viewLifecycleOwner){
            if (it.isNotEmpty()) {
                binding.favRecycler.show(true)
                binding.loading.show(false)
                adapter!!.submitList(it)
            } else {
                binding.favRecycler.show(false)
                binding.loading.show(false)
            }
        }

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FavoriteFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    @SuppressLint("NotifyDataSetChanged")
    override fun addToFavorite(article: Article) {
        if(viewModel.isFavorite(article.title!!)) {
            viewModel.removeFavorite(article.title)
        }
        else {
            viewModel.insertToFavorite(article)
        }
        adapter!!.notifyDataSetChanged()
    }


}