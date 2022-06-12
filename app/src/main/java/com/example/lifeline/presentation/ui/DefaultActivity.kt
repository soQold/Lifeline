package com.example.lifeline.presentation.ui

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.NavHostFragment
import com.example.lifeline.R
import com.example.lifeline.databinding.DefaultActivityBinding
import com.example.lifeline.presentation.BaseActivity

class DefaultActivity : BaseActivity() {
    private lateinit var binding: DefaultActivityBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.default_activity)
        binding.lifecycleOwner = this

        binding.navView.setNavigationItemSelectedListener {
            binding.drawer.closeDrawers()
            when (it.itemId) {
                R.id.itemMain -> {
                    binding.fragmentContainerView.getFragment<NavHostFragment>().navController.navigate(
                        R.id.diary_fragment
                    )
                    true
                }
                R.id.itemFill -> {
                    binding.fragmentContainerView.getFragment<NavHostFragment>().navController.navigate(
                        R.id.fill_fragment
                    )
                    true
                }
                R.id.itemStatistics ->{
                    binding.fragmentContainerView.getFragment<NavHostFragment>().navController.navigate(
                        R.id.statistics_fragment
                    )
                    true
                }
                else -> {
                    showDevelopmentMessage()
                    false
                }
            }
        }
    }
}