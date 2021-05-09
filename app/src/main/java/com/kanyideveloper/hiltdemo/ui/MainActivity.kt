package com.kanyideveloper.hiltdemo.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.kanyideveloper.hiltdemo.databinding.ActivityMainBinding
import com.kanyideveloper.hiltdemo.model.GithubDataModel
import com.kanyideveloper.hiltdemo.network.ResultData
import com.kanyideveloper.hiltdemo.ui.adapter.RepositoriesAdapter
import com.kanyideveloper.hiltdemo.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity(), SwipeRefreshLayout.OnRefreshListener {

    private val TAG = "MainActivity"

    private  val adapter by lazy { RepositoriesAdapter() }
    private lateinit var binding: ActivityMainBinding
    private val mainViewModel : MainViewModel by viewModels()

    private val repositoryObserver = Observer<ResultData<GithubDataModel?>>{ resultData ->
        when(resultData){
            is ResultData.Loading -> {
                binding.progressIndicator.show()

                Log.d(TAG, "Loading ")
            }
            is ResultData.Success -> {
                binding.progressIndicator.hide()
                resultData.data
                adapter.submitList(resultData.data)

                Log.d(TAG, "Success: ${resultData.data?.size.toString()} ")
            }
            is ResultData.Failed -> {
                binding.progressIndicator.hide()

                Log.d(TAG, "Failed: ")
            }
            is ResultData.Exception -> {
                binding.progressIndicator.hide()

                Log.d(TAG, "Exception Caught: ${resultData.exception}")
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Log.d(TAG, "onCreate: ")

        binding.swipeRefresh.setOnRefreshListener(this)

        binding.reposRecyclerview.adapter = adapter
        getDataAndSubscribeEvents()
    }

    override fun onRefresh() {
        binding.swipeRefresh.isRefreshing = false
        getDataAndSubscribeEvents()
    }

    private fun getDataAndSubscribeEvents() {
        val repositoriesListLiveData = mainViewModel.getRepositories()
        repositoriesListLiveData.observe(this,repositoryObserver)
    }
}