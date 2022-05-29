package com.example.lifeline.presentation

import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import timber.log.Timber

abstract class BaseActivity: AppCompatActivity() {
    fun makeToast(text: String){
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show()
    }

    fun log(text: String){
        Timber.i(text)
    }

    fun logError(text: String){
        Timber.e(text)
    }
}