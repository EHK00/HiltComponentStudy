package com.example.customscopetest.model

import com.example.customscopetest.CustomComponent
import com.example.customscopetest.di.CustomComponentEntryPoint
import dagger.hilt.EntryPoints
import dagger.hilt.internal.GeneratedComponentManager
import timber.log.Timber
import javax.inject.Inject
import javax.inject.Provider
import javax.inject.Singleton

@Singleton
class CustomComponentManager @Inject constructor(
    private val customComponentProvider: Provider<CustomComponent.Builder>,
): GeneratedComponentManager<CustomComponent> {
    var customComponent: CustomComponent? = null
        private set

    fun get(): CheckModelHolder {
        val customComponent = customComponent ?: setup()
        return EntryPoints.get(customComponent, CustomComponentEntryPoint::class.java)
            .checkModelHolder()
            .also { Timber.d("__ get checkModelHolder: ${it.hashCode()}") }
    }

    override fun generatedComponent(): CustomComponent {
        return customComponent ?: setup()
    }

    private fun setup(): CustomComponent {
        return customComponentProvider.get()
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