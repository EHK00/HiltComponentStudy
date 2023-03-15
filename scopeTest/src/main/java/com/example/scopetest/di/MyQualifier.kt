package com.example.scopetest.di

import javax.inject.Qualifier

@Qualifier
@Retention(AnnotationRetention.BINARY)
internal annotation class MyQualifier(val value: Type)

enum class Type { SingletonScope, ActivityScope, FragmentScope }
