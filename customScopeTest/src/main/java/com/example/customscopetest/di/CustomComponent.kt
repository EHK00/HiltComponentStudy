package com.example.customscopetest.di

import com.example.customscopetest.model.CheckModel
import com.example.customscopetest.model.CheckModelAdapter
import dagger.BindsInstance
import dagger.hilt.DefineComponent
import dagger.hilt.EntryPoint
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@DefineComponent(parent = SingletonComponent::class)
interface CustomComponent {
    @DefineComponent.Builder
    interface Builder {
        fun setCheckModel(@BindsInstance checkModel: CheckModel): Builder
        fun build(): CustomComponent
    }
}

@InstallIn(CustomComponent::class)
@EntryPoint
interface CustomComponentEntryPoint{
    fun checkModelAdapter(): CheckModelAdapter
}