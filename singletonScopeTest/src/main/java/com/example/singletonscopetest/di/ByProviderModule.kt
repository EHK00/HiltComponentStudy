package com.example.singletonscopetest.di

import com.example.singletonscopetest.model.ByProviderModel
import com.example.singletonscopetest.model.ByProviderModelImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class ByProviderModule {

    @MyQualifier(Type.Normal)
    @Binds
    abstract fun provideNormalByProviderModel(byProvider: ByProviderModelImpl): ByProviderModel

    @MyQualifier(Type.Singleton)
    @Singleton
    @Binds
    abstract fun provideSingletonByProviderModel(byProvider: ByProviderModelImpl): ByProviderModel
}