package com.example.lifeline.presentation.ui.user_activity

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.lifeline.R
import com.example.lifeline.databinding.UserActivityFragmentBinding
import com.example.lifeline.presentation.BaseFragment

class UserActivityFragment : BaseFragment() {
    private lateinit var binding: UserActivityFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding =
            DataBindingUtil.inflate(inflater, R.layout.user_activity_fragment, container, false)
        return binding.root
    }
}