package com.example.scopetest.di

import com.example.scopetest.model.FragmentModel
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.FragmentComponent
import dagger.hilt.android.scopes.FragmentScoped

@InstallIn(FragmentComponent::class)
@Module
object  FragmentLifeCycleModule {
    @Provides
    fun provideFragmentModel(): FragmentModel = FragmentModel()

    @MyQualifier(Type.FragmentScope)
    @FragmentScoped
    @Provides
    fun provideFragmentScopeModel(): FragmentModel = FragmentModel()
}