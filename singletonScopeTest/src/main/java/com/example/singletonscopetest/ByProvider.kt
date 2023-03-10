package com.example.singletonscopetest

import timber.log.Timber

interface ByProvider {
    fun getInstanceInfo(): String
}

class ByProviderImpl(
    val module: CommonModel
) : ByProvider {
    override fun getInstanceInfo(): String {
        Timber.d("__ instance info")
        return this.toString()
    }
}