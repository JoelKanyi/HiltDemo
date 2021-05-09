package com.kanyideveloper.hiltdemo.repository

import com.kanyideveloper.hiltdemo.model.GithubDataModel
import com.kanyideveloper.hiltdemo.network.ApiService
import com.kanyideveloper.hiltdemo.network.ResultData
import javax.inject.Inject
class DataRepository @Inject constructor(private val apiService: ApiService){
    suspend fun getPublicRepositories(): ResultData<GithubDataModel> {
        val githubRepositories = apiService.getPublicRepositories()
        return if (!apiService.getPublicRepositories().isNullOrEmpty()) {
            ResultData.Success(githubRepositories)
        } else {
            ResultData.Failed()
        }
    }
}