package com.example.customscopetest

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.customscopetest.databinding.ActivityCustomScopeBinding
import com.example.customscopetest.di.CustomComponentEntryPoint
import com.example.customscopetest.model.CheckModel
import com.example.customscopetest.model.CheckModelAdapter
import com.example.customscopetest.model.CustomComponentManager
import dagger.hilt.EntryPoints
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber
import javax.inject.Inject

@AndroidEntryPoint
class CustomScopeTestActivity : AppCompatActivity() {

    @Inject
    lateinit var customComponentManager: CustomComponentManager

    private var checkModelAdapter: CheckModelAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityCustomScopeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        customComponentManager.customComponent?.let {
            checkModelAdapter = EntryPoints.get(it, CustomComponentEntryPoint::class.java)
                .checkModelAdapter()
        } ?: run { checkModelAdapter = null }

        binding.btnNewInstance.setOnClickListener {
            customComponentManager.setup(CheckModel())
            customComponentManager.customComponent?.let {
                checkModelAdapter = EntryPoints.get(it, CustomComponentEntryPoint::class.java)
                    .checkModelAdapter()
            }
        }

        binding.btnNextActivity.setOnClickListener {
            startActivity(Intent(this, CustomScopeTestActivity2::class.java))
            finish()
        }

        binding.btnCheck.setOnClickListener {
            checkModelAdapter?.let {
                Timber.d("__ ${it.checkModel}")
            } ?: run { Timber.d("__ checkModelAdapter is null") }
        }
    }


}