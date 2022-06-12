package com.example.lifeline.presentation

import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.lifeline.R
import timber.log.Timber

abstract class BaseActivity : AppCompatActivity() {
    fun makeToast(text: String) {
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show()
    }

    fun log(text: String) {
        Timber.i(text)
    }

    fun logError(text: String) {
        Timber.e(text)
    }

    fun showDevelopmentMessage() {
        Toast.makeText(this, getString(R.string.development_message), Toast.LENGTH_SHORT).show()
    }
}