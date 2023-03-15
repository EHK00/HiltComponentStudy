package com.example.customscopetest

import dagger.hilt.DefineComponent
import dagger.hilt.components.SingletonComponent

@CustomScope
@DefineComponent(parent = SingletonComponent::class)
interface CustomComponent {

    @DefineComponent.Builder
    interface Builder {
        fun build(): CustomComponent
    }
}
