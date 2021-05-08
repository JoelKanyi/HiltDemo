package com.kanyideveloper.hiltdemo.di

import com.kanyideveloper.hiltdemo.repositories.DataRepository
import com.kanyideveloper.hiltdemo.usecase.DataUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent

@InstallIn(ActivityRetainedComponent::class)

@Module
object UseCaseModule {
    @Provides
    fun proviedsUseCase(dataRepository: DataRepository) : DataUseCase{
        return DataUseCase(dataRepository)
    }
}