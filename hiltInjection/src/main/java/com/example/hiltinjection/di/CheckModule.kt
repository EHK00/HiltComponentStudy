package com.example.hiltinjection.di

import com.example.hiltinjection.model.CheckModel
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
class CheckModule {
    @Provides
    fun provideCheckModel(): CheckModel = CheckModel()
}