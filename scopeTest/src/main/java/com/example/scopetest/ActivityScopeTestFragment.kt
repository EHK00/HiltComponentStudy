package com.example.scopetest

import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.scopetest.di.MyQualifier
import com.example.scopetest.di.Type
import com.example.scopetest.model.ActivityModel
import com.example.singletonscopetest.R
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber
import javax.inject.Inject

@AndroidEntryPoint
class ActivityScopeTestFragment: Fragment(R.layout.fragment_scope_test) {
    companion object{
        const val TAG = "ActivityScopeTestFragment"
    }

    @Inject
    lateinit var activityModel: ActivityModel

    @MyQualifier(Type.ActivityScope)
    @Inject
    lateinit var activityScopeModel: ActivityModel

    init {
        Timber.d("__ Fragment Instance Created")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Timber.d("__ activityModel : ${activityModel.hashCode()}")
        Timber.d("__ activityScopeModel : ${activityScopeModel.hashCode()}")
    }

    override fun onDestroy() {
        super.onDestroy()
        Timber.d("__ Fragment onDestroy called")
    }
}