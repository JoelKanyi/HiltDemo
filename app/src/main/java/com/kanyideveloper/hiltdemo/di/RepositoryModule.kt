package com.kanyideveloper.hiltdemo.di

import com.kanyideveloper.hiltdemo.network.ApiService
import com.kanyideveloper.hiltdemo.repository.DataRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent

@InstallIn(ActivityRetainedComponent::class)

@Module
object RepositoryModule{

    @Provides
    fun providesDataRepo(apiService: ApiService) : DataRepository{
        return DataRepository(apiService)
    }
}
