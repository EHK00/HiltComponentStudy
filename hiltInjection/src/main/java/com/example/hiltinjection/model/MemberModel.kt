package com.example.hiltinjection.model

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import dagger.hilt.EntryPoint
import dagger.hilt.InstallIn
import dagger.hilt.android.EntryPointAccessors
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.scopes.ActivityScoped
import dagger.hilt.components.SingletonComponent
import javax.inject.Inject
import javax.inject.Singleton

class MemberModel {
    lateinit var checkModel: CheckModel

    fun getMemberHashCode(activity: AppCompatActivity): Int{
        val hiltEntryPoint = EntryPointAccessors.fromActivity(activity, MemberModelEntryPoint::class.java)
        checkModel = hiltEntryPoint.checkModel()
        return checkModel.hashCode()
    }

    @EntryPoint
    @InstallIn(ActivityComponent::class)
    interface MemberModelEntryPoint{
        fun checkModel(): CheckModel
    }
}