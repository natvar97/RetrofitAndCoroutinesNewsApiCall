package com.example.retrofitandcoroutines.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofitandcoroutines.R
import com.example.retrofitandcoroutines.viewmodel.NewsViewModel
import com.example.retrofitandcoroutines.viewmodel.ViewModelFactory

class MainActivity : AppCompatActivity() {

    private lateinit var newsViewModel: NewsViewModel

    private lateinit var recyclerView: RecyclerView
    private lateinit var newsAdapter: NewsRecyclerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        newsViewModel = ViewModelProvider(this, ViewModelFactory())
            .get(NewsViewModel::class.java)

        newsAdapter = NewsRecyclerAdapter()

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = newsAdapter

        newsViewModel.getAllNews().observe(this, Observer { newsEntity ->
            newsAdapter.addAll(newsEntity.articles!!)
        })

    }
}