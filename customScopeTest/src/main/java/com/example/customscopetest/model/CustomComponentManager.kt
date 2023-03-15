package com.example.customscopetest.model

import com.example.customscopetest.CustomComponent
import dagger.hilt.EntryPoint
import dagger.hilt.EntryPoints
import dagger.hilt.InstallIn
import timber.log.Timber
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CustomComponentManager @Inject constructor(
    private val customComponentProvider: CustomComponent.Builder,
) : CustomComponent {

    @InstallIn(CustomComponent::class)
    @EntryPoint
    interface CustomComponentEntryPoint {
        fun checkModelHolder(): CheckModelHolder
    }

    var customComponent: CustomComponent? = null
        private set

    fun get(): CheckModelHolder {
        val customComponent = customComponent ?: setup()
        return EntryPoints.get(customComponent, CustomComponentEntryPoint::class.java)
            .checkModelHolder()
            .also { Timber.d("__ get checkModelHolder: ${it.hashCode()}") }
    }

    private fun setup(): CustomComponent {
        return customComponentProvider
            .build()
            .also {
                customComponent = it
                Timber.d("__ setup")
            }
    }

    fun release() {
        Timber.d("__ release")
        customComponent = null
    }
}