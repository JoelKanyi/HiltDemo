package com.kanyideveloper.hiltdemo.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.kanyideveloper.hiltdemo.model.GithubDataModel
import com.kanyideveloper.hiltdemo.network.ResultData
import com.kanyideveloper.hiltdemo.repository.DataRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import java.lang.Exception
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val dataRepository: DataRepository) : ViewModel() {
    fun getRepositories(): LiveData<ResultData<GithubDataModel?>> {
        return flow {
            emit(ResultData.Loading())
            try {
                emit(dataRepository.getPublicRepositories())
            }
            catch (e : Exception){
                e.printStackTrace()
                emit(ResultData.Exception())
            }
        }.asLiveData(Dispatchers.IO)
    }
}