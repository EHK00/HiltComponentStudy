package com.example.singletonscopetest.model

import timber.log.Timber
import javax.inject.Inject

interface ByProviderModel

class ByProviderModelImpl(
    val module: CommonModel
) : ByProviderModel