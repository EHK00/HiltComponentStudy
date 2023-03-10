package com.example.singletonscopetest.model

import dagger.hilt.android.scopes.FragmentScoped
import timber.log.Timber
import javax.inject.Inject
import javax.inject.Singleton

interface ByConstructorInjectModel

//@FragmentScoped
class ByConstructorInjectModelImpl @Inject constructor(
    val module: CommonModel
) : ByConstructorInjectModel