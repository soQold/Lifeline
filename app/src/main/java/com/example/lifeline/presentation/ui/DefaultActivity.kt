package com.example.lifeline.presentation.ui

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
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
    }
}