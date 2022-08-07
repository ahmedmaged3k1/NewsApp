package com.example.newsapp.app.features.home

import android.os.Bundle
import android.service.controls.ControlsProviderService.TAG
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.RecyclerView
import com.example.newsapp.R
import com.example.newsapp.databinding.FragmentNewsBinding
import com.example.newsapp.entities.News
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlin.math.log


class NewsFragment : Fragment() {

    private lateinit var binding: FragmentNewsBinding
    private val newsRecyclerViewAdapter = NewsRecyclerViewAdapter()
    private  val viewModel: NewsViewModel by activityViewModels()
    private lateinit var newsList : List<News>
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentNewsBinding.inflate(inflater, container, false)
        recycleViewInitialization()

        return binding.root
    }
    private fun recycleViewInitialization() {
        val moviesRecyclerView: RecyclerView = binding.newsRecyclerView
        moviesRecyclerView.adapter = newsRecyclerViewAdapter

        initializeNews()

    }
    private fun initializeNews(){
        CoroutineScope(IO).launch {
            viewModel.getAllArticles("samsung")
        }

        viewModel.newsList.observe(viewLifecycleOwner, Observer {
            Log.d(TAG, "initializeNews: entering  ")
            val map = it.map { it }
            newsRecyclerViewAdapter.submitList(map)
            Log.d(TAG, "initializeNews: ${map.size}")
        })
    }


}