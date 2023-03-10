package com.example.singletonscopetest.di

import com.example.singletonscopetest.model.ByProviderModel
import com.example.singletonscopetest.model.DestinationModel
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.FragmentComponent
import timber.log.Timber

@Module
@InstallIn(FragmentComponent::class)
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

    @MyQualifier(Type.Fragment)
    @Provides
    fun provideFragmentScopedDestinationModel(
        @MyQualifier(Type.Fragment) model1: ByProviderModel,
        @MyQualifier(Type.Fragment) model2: ByProviderModel,
    ): DestinationModel {
        Timber.d("__ onProvideCalled :Fragment ${model1.hashCode()}")
        Timber.d("__ onProvideCalled :Fragment ${model2.hashCode()}")
        return DestinationModel(
            byProvider = model1,
            byProvider2 = model2,
        )
    }
}