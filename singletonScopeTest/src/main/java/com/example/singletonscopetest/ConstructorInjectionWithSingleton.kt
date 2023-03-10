package com.example.singletonscopetest

import com.example.singletonscopetest.model.CommonModel
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