package com.example.hiltinjection

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.hiltinjection.model.ConstructorModel
import com.example.hiltinjection.model.MemberModel
import com.example.hiltinjection.model.ProvideModel
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber
import javax.inject.Inject

@AndroidEntryPoint
class InjectionTestActivity: AppCompatActivity() {

    @Inject
    lateinit var constructorModel: ConstructorModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val memberModel = MemberModel()
        val memberModel2 = MemberModel()
        Timber.d("__members ${memberModel.getMemberHashCode(this)}")
        Timber.d("__members ${memberModel2.getMemberHashCode(this)}")
    }
}