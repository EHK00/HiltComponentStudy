package com.example.customscopetest.model

import com.example.customscopetest.di.CustomScope
import javax.inject.Inject

@CustomScope
class CheckModelAdapter @Inject constructor(
    val checkModel: CheckModel
) {

}