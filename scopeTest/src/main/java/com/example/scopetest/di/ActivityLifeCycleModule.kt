package com.example.scopetest.di

import com.example.scopetest.model.ActivityModel
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.scopes.ActivityScoped

@InstallIn(ActivityComponent::class)
@Module
object ActivityLifeCycleModule {

    @Provides
    fun provideActivityModel(): ActivityModel = ActivityModel()

    @MyQualifier(Type.ActivityScope)
    @ActivityScoped
    @Provides
    fun provideActivityScopeModel(): ActivityModel = ActivityModel()

//    @MyQualifier(Type.SingletonScope)
//    @Singleton
//    @Provides
//    fun provideSingletonScopeModel(): ActivityModel = ActivityModel()
}