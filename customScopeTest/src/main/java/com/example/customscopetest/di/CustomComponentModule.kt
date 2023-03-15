package com.example.customscopetest.di

import com.example.customscopetest.CustomComponent
import com.example.customscopetest.CustomScope
import com.example.customscopetest.model.CheckModel
import com.example.customscopetest.model.CheckModelHolder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn

@InstallIn(CustomComponent::class)
@Module
object CustomComponentModule {
    @Provides
    fun provideCheckModel() = CheckModel()

    @CustomScope
    @Provides
    fun provideCheckModelHolder(
        checkModel: CheckModel
    ) = CheckModelHolder(checkModel)
}
