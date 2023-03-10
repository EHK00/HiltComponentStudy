package com.example.singletonscopetest

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.commit
import androidx.fragment.app.commitNow
import com.example.singletonscopetest.databinding.ActivitySingletonScopeTestBinding
import com.example.singletonscopetest.di.MyQualifier
import com.example.singletonscopetest.di.Type
import com.example.singletonscopetest.model.DestinationModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class SingletonScopeTestActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivitySingletonScopeTestBinding.inflate(layoutInflater)
        setContentView(binding.root)
        bindButton(binding)
    }

    private fun bindButton(binding: ActivitySingletonScopeTestBinding) {
        binding.btToggleFragment.setOnClickListener {
            val fragment = supportFragmentManager.findFragmentByTag(SingletonScopeTestFragment.TAG)
            if (fragment != null) {
                supportFragmentManager.commitNow {
                    remove(fragment)
                }
            } else {
                supportFragmentManager.commitNow {
                    replace(binding.container.id, SingletonScopeTestFragment(), SingletonScopeTestFragment.TAG)
                }
            }
        }

    }
}