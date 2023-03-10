package com.example.singletonscopetest.di

import com.example.singletonscopetest.model.ByProviderModel
import com.example.singletonscopetest.model.DestinationModel
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import timber.log.Timber

@Module
@InstallIn(SingletonComponent::class)
object DestinationModelModule {
    @MyQualifier(Type.Normal)
    @Provides
    fun provideNormalDestinationModel(
        @MyQualifier(Type.Normal) model1: ByProviderModel,
        @MyQualifier(Type.Normal) model2: ByProviderModel,
    ): DestinationModel {
        Timber.d("__ onProvideCalled :Normal ${model1.hashCode()}")
        Timber.d("__ onProvideCalled :Normal ${model2.hashCode()}")
        return DestinationModel(
            byProvider = model1,
            byProvider2 = model2,
        )
    }

    @MyQualifier(Type.Singleton)
    @Provides
    fun provideSingletonDestinationModel(
        @MyQualifier(Type.Singleton) model1: ByProviderModel,
        @MyQualifier(Type.Singleton) model2: ByProviderModel,
    ): DestinationModel {
        Timber.d("__ onProvideCalled :Singleton ${model1.hashCode()}")
        Timber.d("__ onProvideCalled :Singleton ${model2.hashCode()}")
        return DestinationModel(
            byProvider = model1,
            byProvider2 = model2,
        )
    }
}