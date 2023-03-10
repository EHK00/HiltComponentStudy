package com.example.singletonscopetest.model

import com.example.singletonscopetest.di.MyQualifier
import com.example.singletonscopetest.di.Type
import com.example.singletonscopetest.model.ByConstructorInjectModel
import com.example.singletonscopetest.model.ByProviderModel
import timber.log.Timber
import javax.inject.Inject

class DestinationModel2(
    private val model1: ByConstructorInjectModel,
    private val model2: ByConstructorInjectModel,
)