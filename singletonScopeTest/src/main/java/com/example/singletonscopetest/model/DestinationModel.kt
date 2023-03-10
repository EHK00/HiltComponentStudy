package com.example.singletonscopetest.model

import com.example.singletonscopetest.model.ByProviderModel

class DestinationModel(
    private val byProvider: ByProviderModel,
    private val byProvider2: ByProviderModel,
)