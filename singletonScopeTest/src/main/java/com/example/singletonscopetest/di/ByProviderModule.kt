package com.example.singletonscopetest.di

import com.example.singletonscopetest.model.ByProviderModel
import com.example.singletonscopetest.model.ByProviderModelImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.FragmentComponent
import dagger.hilt.android.scopes.FragmentScoped

@Module
@InstallIn(FragmentComponent::class)
abstract class ByProviderModule {

    @MyQualifier(Type.Normal)
    @Binds
    abstract fun provideNormalByProviderModel(byProvider: ByProviderModelImpl): ByProviderModel

    @MyQualifier(Type.Fragment)
    @FragmentScoped
    @Binds
    abstract fun provideSingletonByProviderModel(byProvider: ByProviderModelImpl): ByProviderModel
}