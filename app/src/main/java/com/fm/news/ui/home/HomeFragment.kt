package com.fm.news.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import com.fm.news.callback.FavoriteInterface
import com.fm.news.databinding.HomeFragmentBinding
import com.fm.news.model.Article
import com.fm.news.ui.adapter.NewsAdapter
import com.fm.news.utils.fillRecycler
import com.fm.news.utils.show
import com.fm.news.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment(), FavoriteInterface {

    private lateinit var binding: HomeFragmentBinding

    private val viewModel: MainViewModel by activityViewModels()
    private var adapter: NewsAdapter? = null
    var isFav = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.getNews("bitcoin")
        adapter = NewsAdapter(viewModel, this)
        binding.newsRecycler.fillRecycler(activity!!, adapter!!)


        viewModel.newsLv.observe(viewLifecycleOwner) {

            if (it.articles.isNotEmpty()) {
                binding.newsRecycler.show(true)
                binding.loading.show(false)
                adapter!!.submitList(it.articles)
            } else {
                binding.newsRecycler.show(false)
                binding.loading.show(true)
            }
        }

    }

    override fun addToFavorite(article: Article) {

        val isFav= article.title?.let { viewModel.isFavorite(it) }
        if (isFav!!) {
                viewModel.removeFavorite(article.title!!)
            }
        else {
            viewModel.insertToFavorite(article)
        }

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = HomeFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }


}