package com.example.hiltinjection

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.hiltinjection.model.ConstructorModel
import com.example.hiltinjection.model.MemberModel
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber
import javax.inject.Inject

@AndroidEntryPoint
class InjectionTestActivity: AppCompatActivity() {

    @Inject
    lateinit var constructorModel: ConstructorModel

    @Inject
    lateinit var memberModel: MemberModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Timber.d("__ ${constructorModel.hashCode()}, ${memberModel.hashCode()}")
        Timber.d("__ ${memberModel.checkModel.hashCode()}")
    }
}