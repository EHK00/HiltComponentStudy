package com.example.customscopetest

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.customscopetest.databinding.ActivityCustomScope2Binding
import com.example.customscopetest.di.CustomComponentEntryPoint
import com.example.customscopetest.model.CheckModelAdapter
import com.example.customscopetest.model.CustomComponentManager
import dagger.hilt.EntryPoints
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber
import javax.inject.Inject

@AndroidEntryPoint
class CustomScopeTestActivity2 : AppCompatActivity() {

    @Inject
    lateinit var customComponentManager: CustomComponentManager

    private var checkModelAdapter: CheckModelAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityCustomScope2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        customComponentManager.customComponent?.let {
            checkModelAdapter = EntryPoints.get(it, CustomComponentEntryPoint::class.java)
                .checkModelAdapter()
        } ?: run { checkModelAdapter = null }

        binding.btnRelease.setOnClickListener {
            customComponentManager.release()
        }

        binding.btnBack.setOnClickListener {
            startActivity(Intent(this, CustomScopeTestActivity::class.java))
            finish()
        }

        binding.btnCheck.setOnClickListener {
            checkModelAdapter?.let {
                Timber.d("__ ${it.checkModel}")
            } ?: run { Timber.d("__ checkModelAdapter is null") }
        }
    }


}