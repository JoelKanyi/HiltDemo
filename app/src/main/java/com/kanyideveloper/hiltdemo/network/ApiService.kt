package com.kanyideveloper.hiltdemo.network

import com.kanyideveloper.hiltdemo.model.Opensource254ReposModel
import com.kanyideveloper.hiltdemo.utils.Constants.END_POINT
import retrofit2.http.GET

interface ApiService {
    @GET(END_POINT)
    suspend fun getPublicRepositories(): Opensource254ReposModel
}