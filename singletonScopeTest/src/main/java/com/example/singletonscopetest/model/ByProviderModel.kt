package com.example.singletonscopetest.model

import timber.log.Timber
import javax.inject.Inject

interface ByProviderModel {
    fun getInstanceInfo(): String
}

class ByProviderModelImpl @Inject constructor(
    val module: CommonModel
) : ByProviderModel {
    override fun getInstanceInfo(): String {
        Timber.d("__ instance info")
        return this.toString()
    }
}