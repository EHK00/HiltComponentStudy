package com.example.customscopetest.model

import timber.log.Timber
import javax.inject.Inject

class CheckModel @Inject constructor() {
    init {
        Timber.d("__ init check model : ${this.hashCode()}")
    }
}