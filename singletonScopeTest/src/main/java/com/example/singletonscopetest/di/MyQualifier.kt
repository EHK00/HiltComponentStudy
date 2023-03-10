package com.example.singletonscopetest.di

import javax.inject.Qualifier

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class MyQualifier(val value: Type)

enum class Type { Singleton, Normal }
