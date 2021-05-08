package com.kanyideveloper.hiltdemo.network

import com.kanyideveloper.hiltdemo.model.GithubDataModel
import com.kanyideveloper.hiltdemo.utils.Constants.END_POINT
import retrofit2.http.GET

interface ApiService {
    @GET(END_POINT)
    suspend fun getPublicRepositories() : GithubDataModel
}