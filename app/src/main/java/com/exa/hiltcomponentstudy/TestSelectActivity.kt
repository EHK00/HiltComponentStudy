package com.exa.hiltcomponentstudy

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.exa.hiltcomponentstudy.databinding.ActivityTestSelectBinding
import com.example.hiltinjection.InjectionTestActivity
import com.example.scopetest.ScopeTestActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TestSelectActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityTestSelectBinding.inflate(layoutInflater)
        setContentView(binding.root)


        bindButtons(binding)
    }

    private fun bindButtons(bind: ActivityTestSelectBinding) {
        bind.btnSingletonScope.setOnClickListener {
            val intent = Intent(this, ScopeTestActivity::class.java)
            startActivity(intent)
        }
        bind.btHiltInjection.setOnClickListener {
            val intent = Intent(this, InjectionTestActivity::class.java)
            startActivity(intent)
        }
    }
}