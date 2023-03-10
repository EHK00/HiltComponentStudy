package com.example.singletonscopetest

import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.singletonscopetest.di.MyQualifier
import com.example.singletonscopetest.di.Type
import com.example.singletonscopetest.model.DestinationModel
import com.example.singletonscopetest.model.DestinationModel2
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber
import javax.inject.Inject


@AndroidEntryPoint
class SingletonScopeTestFragment : Fragment(R.layout.fragment_singleton_scope_test) {
    companion object {
        const val TAG = "SingletonScopeTestFragment"
    }

    // ByProvider test
    @Inject
    @MyQualifier(Type.Normal)
    lateinit var model: DestinationModel

    @Inject
    @MyQualifier(Type.FragmentScope)
    lateinit var model2: DestinationModel

    // 생성자 + @Inject annotation 테스트
    @Inject
    @MyQualifier(Type.Normal)
    lateinit var model3: DestinationModel2
    @Inject
    @MyQualifier(Type.FragmentScope)
    lateinit var model4: DestinationModel2

    init {
        Timber.d("Fragment Instance Created")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Timber.d("Fragment onCreate called")
    }

    override fun onDestroy() {
        super.onDestroy()
        Timber.d("Fragment onDestroy called")
    }

}