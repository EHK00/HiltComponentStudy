package com.example.hiltinjection.model

import androidx.appcompat.app.AppCompatActivity
import javax.inject.Inject


class MemberModel @Inject constructor() {
    @Inject
    lateinit var checkModel: CheckModel

    fun getMemberHashCode(activity: AppCompatActivity): Int{
        return checkModel.hashCode()
//        val hiltEntryPoint = EntryPointAccessors.fromActivity(activity, MemberModelEntryPoint::class.java)
//        checkModel = hiltEntryPoint.checkModel()
//        return checkModel.hashCode()
    }

//    @EntryPoint
//    @InstallIn(ActivityComponent::class)
//    interface MemberModelEntryPoint{
//        fun checkModel(): CheckModel
//    }
}