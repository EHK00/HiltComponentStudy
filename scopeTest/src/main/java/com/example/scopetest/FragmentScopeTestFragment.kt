package com.example.scopetest

import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.scopetest.di.MyQualifier
import com.example.scopetest.di.Type
import com.example.scopetest.model.FragmentModel
import com.example.singletonscopetest.R
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber
import javax.inject.Inject


@AndroidEntryPoint
class FragmentScopeTestFragment : Fragment(R.layout.fragment_scope_test) {
    companion object {
        const val TAG = "FragmentScopeTestFragment"
    }

    @Inject
    lateinit var fragmentModel1: FragmentModel

    @Inject
    lateinit var fragmentModel2: FragmentModel

    @MyQualifier(Type.FragmentScope)
    @Inject
    lateinit var fragmentScopeModel1: FragmentModel

    @MyQualifier(Type.FragmentScope)
    @Inject
    lateinit var fragmentScopeModel2: FragmentModel

    init {
        Timber.d("__ Fragment Instance Created")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Timber.d("__ fragmentModel: ${fragmentModel1.hashCode()}, ${fragmentModel2.hashCode()}")
        Timber.d("__ fragmentScopeModel: ${fragmentScopeModel1.hashCode()}, ${fragmentScopeModel2.hashCode()}")
    }

    override fun onDestroy() {
        super.onDestroy()
        Timber.d("__ Fragment onDestroy called")
    }

}