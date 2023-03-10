package com.example.singletonscopetest.di

import com.example.singletonscopetest.model.ByConstructorInjectModel
import com.example.singletonscopetest.model.ByProviderModel
import com.example.singletonscopetest.model.DestinationModel
import com.example.singletonscopetest.model.DestinationModel2
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
        Timber.d("__ onProvideCalled :Fragment ${model1.hashCode()}, ${model2.hashCode()}")
        return DestinationModel(
            byProvider = model1,
            byProvider2 = model2,
        )
    }

    @MyQualifier(Type.FragmentScope)
    @Provides
    fun provideFragmentScopedDestinationModel(
        @MyQualifier(Type.FragmentScope) model1: ByProviderModel,
        @MyQualifier(Type.FragmentScope) model2: ByProviderModel,
    ): DestinationModel {
        Timber.d("__ onProvideCalled :Fragment ${model1.hashCode()}, ${model2.hashCode()}")
        return DestinationModel(
            byProvider = model1,
            byProvider2 = model2,
        )
    }

    @MyQualifier(Type.Normal)
    @Provides
    fun provideDestinationModel2(
        @MyQualifier(Type.Normal) model1: ByConstructorInjectModel,
        @MyQualifier(Type.Normal) model2: ByConstructorInjectModel,
    ): DestinationModel2 {
        Timber.d("__ onProvideCalled :Normal ${model1.hashCode()}, ${model2.hashCode()}")
        return DestinationModel2(
            model1 = model1,
            model2 = model2,
        )
    }

    @MyQualifier(Type.FragmentScope)
    @Provides
    fun provideFragmentScopeDestinationModel2(
        @MyQualifier(Type.FragmentScope) model1: ByConstructorInjectModel,
        @MyQualifier(Type.FragmentScope) model2: ByConstructorInjectModel,
    ): DestinationModel2 {
        Timber.d("__ onProvideCalled :Fragment ${model1.hashCode()}, ${model2.hashCode()}")
        return DestinationModel2(
            model1 = model1,
            model2 = model2,
        )
    }
}