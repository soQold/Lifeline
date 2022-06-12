package com.example.lifeline.presentation.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class DefaultViewModel: ViewModel() {
    val title = MutableLiveData<String>()
}