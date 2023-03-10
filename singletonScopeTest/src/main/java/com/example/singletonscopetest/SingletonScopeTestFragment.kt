package com.example.singletonscopetest

import androidx.fragment.app.Fragment
import com.example.singletonscopetest.di.MyQualifier
import com.example.singletonscopetest.di.Type
import com.example.singletonscopetest.model.DestinationModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject


@AndroidEntryPoint
class SingletonScopeTestFragment : Fragment(R.layout.fragment_singleton_scope_test) {
    companion object {
        const val TAG = "SingletonScopeTestFragment"
    }

    @Inject
    @MyQualifier(Type.Normal)
    lateinit var model: DestinationModel

    @Inject
    @MyQualifier(Type.Fragment)
    lateinit var model2: DestinationModel

}