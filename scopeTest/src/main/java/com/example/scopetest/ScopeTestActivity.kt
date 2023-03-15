package com.example.scopetest

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.commitNow
import com.example.scopetest.di.MyQualifier
import com.example.scopetest.di.Type
import com.example.scopetest.model.ActivityModel
import com.example.singletonscopetest.databinding.ActivityScopeTestBinding
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber
import javax.inject.Inject

@AndroidEntryPoint
class ScopeTestActivity : AppCompatActivity() {

    @Inject
    lateinit var activityModel: ActivityModel

    @MyQualifier(Type.ActivityScope)
    @Inject
    lateinit var activityScopeModel: ActivityModel

//    @MyQualifier(Type.SingletonScope)
//    @Inject
//    lateinit var singletonScopeModel: ActivityModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityScopeTestBinding.inflate(layoutInflater)
        setContentView(binding.root)
        bindButton(binding)

        Timber.d("__ activityModel : ${activityModel.hashCode()}")
        Timber.d("__ activityScopeModel : ${activityScopeModel.hashCode()}")
//        Timber.d("__ singletonScopeModel : ${singletonScopeModel.hashCode()}")
    }

    private fun bindButton(binding: ActivityScopeTestBinding) {
        binding.btToggleFragment.setOnClickListener {
            supportFragmentManager.commitNow {
                val fragment = supportFragmentManager.findFragmentByTag(ActivityScopeTestFragment.TAG)
                if (fragment != null) {
                    remove(fragment)
                } else {
                    add(binding.container.id, ActivityScopeTestFragment(), ActivityScopeTestFragment.TAG)
                }
            }
        }

        binding.btToggleFragment2.setOnClickListener {
            supportFragmentManager.commitNow {
                val fragment = supportFragmentManager.findFragmentByTag(FragmentScopeTestFragment.TAG)
                if (fragment != null) {
                    remove(fragment)
                } else {
                    add(binding.container.id, FragmentScopeTestFragment(), FragmentScopeTestFragment.TAG)
                }
            }
        }

    }
}