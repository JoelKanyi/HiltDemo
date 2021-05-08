package com.kanyideveloper.hiltdemo.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.kanyideveloper.hiltdemo.model.GithubDataModel
import com.kanyideveloper.hiltdemo.model.ResultData
import com.kanyideveloper.hiltdemo.usecase.DataUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val userCase: DataUseCase) : ViewModel() {
    fun getRepositories(): LiveData<ResultData<GithubDataModel>> {
        return liveData {
            emit(ResultData.Loading())
            emit(userCase.getPublicRepositories())
        }
    }
}