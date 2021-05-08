package com.kanyideveloper.hiltdemo.repositories

import com.kanyideveloper.hiltdemo.model.GithubDataModel
import com.kanyideveloper.hiltdemo.network.ApiService
import javax.inject.Inject

class DataRepository @Inject constructor(private val apiService: ApiService) {
    suspend fun getPublicRepositories(): GithubDataModel {
        return apiService.getPublicRepositories()
    }
}