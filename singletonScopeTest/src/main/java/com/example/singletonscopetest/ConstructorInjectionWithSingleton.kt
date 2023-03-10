package com.example.singletonscopetest

import android.content.Context
import dagger.hilt.android.qualifiers.ApplicationContext
import timber.log.Timber
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ConstructorInjectionWithSingleton @Inject constructor(
    val commonModel: CommonModel
) {
    init {
        Timber.d("__ onProvideCalled : $this")
    }
}