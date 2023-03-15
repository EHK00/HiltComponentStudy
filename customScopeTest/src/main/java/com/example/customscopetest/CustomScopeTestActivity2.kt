package com.example.customscopetest

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.customscopetest.databinding.ActivityCustomScope2Binding
import com.example.customscopetest.model.CheckModelHolder
import com.example.customscopetest.model.CustomComponentManager
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber
import javax.inject.Inject

@AndroidEntryPoint
class CustomScopeTestActivity2 : AppCompatActivity() {

    @Inject
    lateinit var customComponentManager: CustomComponentManager

    private var checkModelHolder: CheckModelHolder? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityCustomScope2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        checkModelHolder = customComponentManager.get()

        binding.btnRelease.setOnClickListener {
            customComponentManager.release()
        }

        binding.btnBack.setOnClickListener {
            startActivity(Intent(this, CustomScopeTestActivity::class.java))
            finish()
        }

        binding.btnCheck.setOnClickListener {
            checkModelHolder?.let {
                Timber.d("__ checkModel: ${it.checkModel.hashCode()}")
            } ?: run { Timber.d("__ checkModelHolder is null") }
        }
    }


}