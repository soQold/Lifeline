package com.example.lifeline.presentation.ui.sign_in

import android.content.Intent
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.lifeline.R
import com.example.lifeline.databinding.SignInActivityBinding
import com.example.lifeline.presentation.BaseActivity
import com.example.lifeline.presentation.ui.DefaultActivity
import org.koin.android.ext.android.inject

class SignInActivity: BaseActivity() {
    private lateinit var binding: SignInActivityBinding
    private val viewModel: SignInViewModel by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.sign_in_activity)
        binding.lifecycleOwner = this
        binding.model = viewModel
        binding.btnSignIn.setOnClickListener {
            //test account - login:oleg1223, password: test
            viewModel.signIn(
                binding.etUsername.text.toString(),
                binding.etPassword.text.toString()
            )
        }

        viewModel.authResult.observe(this){
            when(it){
                SignInResults.SUCCESS -> {
                    val intent = Intent(this, DefaultActivity::class.java)
                    startActivity(intent)
                }
                SignInResults.USERNAME_ERROR -> makeToast(getString(R.string.status_username_invalid))
                SignInResults.PASSWORD_ERROR -> makeToast(getString(R.string.status_password_invalid))
                SignInResults.RESPONSE_ERROR -> makeToast(getString(R.string.status_response_error))
                SignInResults.TOKEN_ERROR -> makeToast(getString(R.string.status_token_error))
                else -> {
                    logError("null status")
                }
            }
        }
    }
}