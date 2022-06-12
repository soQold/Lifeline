package com.example.lifeline.presentation.ui

import android.os.Bundle
import android.view.Gravity
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.NavHostFragment
import com.example.lifeline.R
import com.example.lifeline.databinding.DefaultActivityBinding
import com.example.lifeline.presentation.BaseActivity
import org.koin.androidx.viewmodel.ext.android.viewModel

class DefaultActivity : BaseActivity() {
    private lateinit var binding: DefaultActivityBinding
    private val defaultViewModel: DefaultViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        defaultViewModel.title.postValue(getString(R.string.main_page))
        binding = DataBindingUtil.setContentView(this, R.layout.default_activity)
        binding.lifecycleOwner = this
        binding.model = defaultViewModel

        binding.toolbar.btnBack.setOnClickListener { onBackPressed() }
        binding.toolbar.btnMenu.setOnClickListener { binding.drawer.openDrawer(Gravity.START) }

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
                R.id.itemStatistics -> {
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