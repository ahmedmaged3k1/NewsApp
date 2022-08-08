package com.example.newsapp.app.features.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.viewpager2.widget.ViewPager2
import com.example.newsapp.databinding.FragmentNewsBinding
import com.wajahatkarim3.easyflipviewpager.CardFlipPageTransformer2
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch


class NewsFragment : Fragment() {

    private lateinit var binding: FragmentNewsBinding
    private val newsRecyclerViewAdapter = NewsRecyclerViewAdapter()
    private val viewModel: NewsViewModel by activityViewModels()

    //private lateinit var newsList: List<News>
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentNewsBinding.inflate(inflater, container, false)
        recycleViewInitialization()
        initializeLocalNews()
        onSwipeViewPager()
        return binding.root
    }

    private fun recycleViewInitialization() {
        val moviesRecyclerView = binding.newsRecyclerView
        moviesRecyclerView.adapter = newsRecyclerViewAdapter
        val cardFlipPageTransformer = CardFlipPageTransformer2()
        cardFlipPageTransformer.isScalable = true

        binding.newsRecyclerView.setPageTransformer(cardFlipPageTransformer)
        initializeNews()

    }

    private fun initializeNews() {
        CoroutineScope(IO).launch {
            viewModel.getAllArticles("samsung")
        }
        observeNews()

    }

    private fun observeNews() {
        viewModel.newsList.observe(viewLifecycleOwner, Observer { list ->
            val map = list.map { it }
            newsRecyclerViewAdapter.submitList(map)
        })
    }

    private fun initializeLocalNews() {
        val newsLocalViewModel = activity?.let { NewsLocalViewModel(it.application) }
        CoroutineScope(IO).launch {
            newsLocalViewModel?.getArticles()
        }
        newsLocalViewModel?.newsList?.observe(viewLifecycleOwner, Observer {


        })
    }

    private fun onSwipeViewPager() {
        binding.newsRecyclerView.registerOnPageChangeCallback(object :
            ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                viewModel.newsList.value?.get(position)?.seen = 1
                newsRecyclerViewAdapter.submitList(viewModel.newsList.value)

            }
        })
    }


}