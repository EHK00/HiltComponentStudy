package com.example.singletonscopetest.di

import com.example.singletonscopetest.model.ByProviderModel
import com.example.singletonscopetest.model.ByProviderModelImpl
import com.example.singletonscopetest.model.CommonModel
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.FragmentComponent
import dagger.hilt.android.scopes.FragmentScoped
import timber.log.Timber

@Module
@InstallIn(FragmentComponent::class)
object ByProviderModule {
    @Provides
    fun provideCommonModel(): CommonModel {
        return CommonModel()
    }

    @MyQualifier(Type.Normal)
    @Provides
    fun provideNormalByProviderModel(commonModel: CommonModel): ByProviderModel {
        return ByProviderModelImpl(commonModel)
    }

    @MyQualifier(Type.FragmentScope)
    @FragmentScoped
    @Provides
    fun provideFragmentScopeByProviderModel(commonModel: CommonModel): ByProviderModel {
        return ByProviderModelImpl(commonModel)
    }
}