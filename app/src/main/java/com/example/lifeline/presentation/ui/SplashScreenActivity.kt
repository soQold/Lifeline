package com.example.lifeline.presentation.ui

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.lifeline.R
import com.example.lifeline.presentation.ui.sign_in.SignInActivity

@SuppressLint("CustomSplashScreen")
class SplashScreenActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.splash_activity)
        refreshAuth()
    }

    private fun refreshAuth(){
        // FIXME add token refresh
        launchApp()
    }

    private fun launchApp(){
        // FIXME add token-based auth
        val intent = Intent(this, SignInActivity::class.java)
        startActivity(intent)
    }
}