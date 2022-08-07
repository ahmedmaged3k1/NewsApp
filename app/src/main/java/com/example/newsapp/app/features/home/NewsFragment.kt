package com.example.newsapp.app.features.home

import android.os.Bundle
import android.service.controls.ControlsProviderService.TAG
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.RecyclerView
import com.example.newsapp.databinding.FragmentNewsBinding
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
        return binding.root
    }

    private fun recycleViewInitialization() {
        val moviesRecyclerView: RecyclerView = binding.newsRecyclerView
        moviesRecyclerView.adapter = newsRecyclerViewAdapter

        initializeNews()

    }

    private fun initializeNews() {
        CoroutineScope(IO).launch {
            viewModel.getAllArticles("samsung")
        }
        viewModel.newsList.observe(viewLifecycleOwner, Observer {
            val map = it.map { it }
            newsRecyclerViewAdapter.submitList(map)
        })
    }

    private fun initializeLocalNews() {
        val newsLocalViewModel = activity?.let { NewsLocalViewModel(it.application) }
        CoroutineScope(IO).launch {
            newsLocalViewModel?.getArticles()
        }
        newsLocalViewModel?.newsList?.observe(viewLifecycleOwner, Observer {
            Log.d(TAG, "initializeLocalNews: ${it.size}")

        })
    }


}