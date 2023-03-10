package com.example.singletonscopetest

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.singletonscopetest.databinding.ActivitySingletonScopeTestBinding
import com.example.singletonscopetest.di.MyQualifier
import com.example.singletonscopetest.di.Type
import com.example.singletonscopetest.model.DestinationModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class SingletonScopeTestActivity : AppCompatActivity() {
    @Inject
    @MyQualifier(Type.Normal)
    lateinit var model: DestinationModel

    @Inject
    @MyQualifier(Type.Singleton)
    lateinit var model2: DestinationModel

    override fun onCreate(savedInstanceState: Bundle?) {
        setContentView(ActivitySingletonScopeTestBinding.inflate(layoutInflater).root)
        super.onCreate(savedInstanceState)
    }
}