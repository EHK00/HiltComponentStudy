package com.example.customscopetest.di

import com.example.customscopetest.model.CheckModel
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn

@InstallIn(CustomComponent::class)
@Module
object CustomComponentModule {
    @CustomScope
    @Provides
    fun provideCheckModel() = CheckModel()
}
