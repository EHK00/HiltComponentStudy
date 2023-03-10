package com.example.singletonscopetest.di

import com.example.singletonscopetest.ByProvider
import com.example.singletonscopetest.ByProviderImpl
import com.example.singletonscopetest.CommonModel
import com.example.singletonscopetest.DestinationModel
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import timber.log.Timber
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object SingletonComponentModule {

    @Provides
    fun provideCommonModel(): CommonModel = CommonModel()

    @MyQualifier(Type.Normal)
    @Provides
    fun provideNormalByProvider(commonModule: CommonModel): ByProvider {
        return ByProviderImpl(commonModule)
    }

    @MyQualifier(Type.Singleton)
    @Singleton
    @Provides
    fun provideSingletonByProvider(commonModule: CommonModel): ByProvider {
        return ByProviderImpl(commonModule)
    }

    @MyQualifier(Type.Normal)
    @Provides
    fun provideNormalDestinationModel(
        @MyQualifier(Type.Normal) model1: ByProvider,
        @MyQualifier(Type.Normal) model2: ByProvider,
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
        @MyQualifier(Type.Singleton) model1: ByProvider,
        @MyQualifier(Type.Singleton) model2: ByProvider,
    ): DestinationModel {
        Timber.d("__ onProvideCalled :Singleton ${model1.hashCode()}")
        Timber.d("__ onProvideCalled :Singleton ${model2.hashCode()}")
        return DestinationModel(
            byProvider = model1,
            byProvider2 = model2,
        )
    }
}