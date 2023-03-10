package com.example.singletonscopetest

import com.example.singletonscopetest.model.CommonModel
import timber.log.Timber
import javax.inject.Inject

class ConstructorInjection @Inject constructor(
    val commonModel: CommonModel
){
    init {
        Timber.d("__ onProvideCalled : $this")
    }
}