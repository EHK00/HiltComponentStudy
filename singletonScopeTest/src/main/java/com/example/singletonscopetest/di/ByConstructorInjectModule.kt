package com.example.singletonscopetest.di

import com.example.singletonscopetest.model.ByConstructorInjectModel
import com.example.singletonscopetest.model.ByConstructorInjectModelImpl
import com.example.singletonscopetest.model.ByProviderModel
import com.example.singletonscopetest.model.ByProviderModelImpl
import com.example.singletonscopetest.model.CommonModel
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.FragmentComponent
import dagger.hilt.android.scopes.FragmentScoped

@Module
@InstallIn(FragmentComponent::class)
abstract class ByConstructorInjectModule {
    @MyQualifier(Type.Normal)
    @Binds
    abstract fun bindByConstructorInjectModel(byConstructorInjectModel: ByConstructorInjectModelImpl): ByConstructorInjectModel

    @MyQualifier(Type.FragmentScope)
    @FragmentScoped
    @Binds
    abstract fun bindFragmentScopeByConstructorInjectModel(byConstructorInjectModel: ByConstructorInjectModelImpl): ByConstructorInjectModel
}