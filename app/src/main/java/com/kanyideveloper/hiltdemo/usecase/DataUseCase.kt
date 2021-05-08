package com.kanyideveloper.hiltdemo.usecase

import com.kanyideveloper.hiltdemo.model.GithubDataModel
import com.kanyideveloper.hiltdemo.model.ResultData
import com.kanyideveloper.hiltdemo.repositories.DataRepository
import javax.inject.Inject

class DataUseCase @Inject constructor(private val dataRepository: DataRepository) {
    suspend fun getPublicRepositories(): ResultData<GithubDataModel> {
        val githubRepositories = dataRepository.getPublicRepositories()

        val resultData = if(!githubRepositories.isNullOrEmpty()){
             ResultData.Success(githubRepositories)
        }else{
            ResultData.Failed("Something went wrong, try again")
        }
        return resultData
    }
}