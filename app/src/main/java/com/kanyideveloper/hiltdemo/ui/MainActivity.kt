package com.kanyideveloper.hiltdemo.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.RecyclerView
import com.kanyideveloper.hiltdemo.R
import com.kanyideveloper.hiltdemo.model.ResultData
import com.kanyideveloper.hiltdemo.ui.adapter.RepositoriesAdapter
import com.kanyideveloper.hiltdemo.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: RepositoriesAdapter

    private val mainViewModel by viewModels<MainViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        adapter = RepositoriesAdapter()

        recyclerView = findViewById(R.id.reposRecyclerview)
        recyclerView.adapter = adapter

        val repositoriesList = mainViewModel.getRepositories()
        repositoriesList.observe(this, Observer { resultData ->
            when(resultData){
                is ResultData.Loading -> {

                }
                is ResultData.Success -> {
                    resultData.data
                    adapter.submitList(resultData.data)
                }
                is ResultData.Failed -> {

                }
                is ResultData.Exception -> {

                }
            }
        })
    }
}