package com.example.customscopetest

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.customscopetest.databinding.ActivityCustomScopeBinding
import com.example.customscopetest.model.CheckModelHolder
import com.example.customscopetest.model.CustomComponentManager
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber
import javax.inject.Inject

@AndroidEntryPoint
class CustomScopeTestActivity : AppCompatActivity() {

    @Inject
    lateinit var customComponentManager: CustomComponentManager

    private var checkModelHolder: CheckModelHolder? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityCustomScopeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        checkModelHolder = customComponentManager.get()

        binding.btnNewInstance.setOnClickListener {
            customComponentManager.release()
            checkModelHolder = customComponentManager.get()
        }

        binding.btnNextActivity.setOnClickListener {
            startActivity(Intent(this, CustomScopeTestActivity2::class.java))
            finish()
        }

        binding.btnCheck.setOnClickListener {
            checkModelHolder?.let {
                Timber.d("__ checkModel: ${it.checkModel.hashCode()}")
            } ?: run { Timber.d("__ checkModelHolder is null") }
        }
    }


}