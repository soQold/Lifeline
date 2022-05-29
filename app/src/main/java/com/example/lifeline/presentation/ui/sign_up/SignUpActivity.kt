package com.example.lifeline.presentation.ui.sign_up

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.lifeline.R
import com.example.lifeline.databinding.SignUpActivityBinding
import com.example.lifeline.presentation.BaseActivity
import org.koin.android.ext.android.inject

class SignUpActivity: BaseActivity() {
    private lateinit var binding: SignUpActivityBinding
    private val viewModel: SignUpViewModel by inject()
    private val signUpFragment = SignUpFragment()
    private val signUpPersonalFragment = SignUpPersonalFragment()
    private val signUpParametersFragment = SignUpParametersFragment()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.sign_up_activity)
        binding.lifecycleOwner = this
        binding.model = viewModel

        viewModel.step.observe(this){
            when(it){
                1 -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.fragmentContainer, signUpFragment)
                        .addToBackStack(null)
                        .commit()
                }
                2 -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.fragmentContainer, signUpPersonalFragment)
                        .addToBackStack(null)
                        .commit()
                }
                3 -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.fragmentContainer, signUpParametersFragment)
                        .addToBackStack(null)
                        .commit()
                }
                4 -> {

                }
            }
        }
    }
}