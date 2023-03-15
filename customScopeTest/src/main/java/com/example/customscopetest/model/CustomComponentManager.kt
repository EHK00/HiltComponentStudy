package com.example.customscopetest.model

import com.example.customscopetest.di.CustomComponent
import javax.inject.Inject
import javax.inject.Provider
import javax.inject.Singleton

@Singleton
class CustomComponentManager @Inject constructor(
    private val customComponentProvider: Provider<CustomComponent.Builder>,
) {
    var customComponent: CustomComponent? = null
        private set

    fun setup(checkModel: CheckModel) {
        customComponent = customComponentProvider.get()
            .setCheckModel(checkModel)
            .build()
    }

    fun release(){
        customComponent = null
    }
}