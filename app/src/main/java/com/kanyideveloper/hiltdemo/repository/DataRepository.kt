package com.kanyideveloper.hiltdemo.repository

import com.kanyideveloper.hiltdemo.model.Opensource254ReposModel
import com.kanyideveloper.hiltdemo.network.ApiService
import com.kanyideveloper.hiltdemo.network.ResultData
import javax.inject.Inject

class DataRepository @Inject constructor(private val apiService: ApiService) {
    suspend fun getPublicRepositories(): ResultData<Opensource254ReposModel> {
        val githubRepositories = apiService.getPublicRepositories()
        return if (!apiService.getPublicRepositories().isNullOrEmpty()) {
            ResultData.Success(githubRepositories)
        } else {
            ResultData.Failed()
        }
    }
}