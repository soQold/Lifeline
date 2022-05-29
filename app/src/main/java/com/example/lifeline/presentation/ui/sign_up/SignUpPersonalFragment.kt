package com.example.lifeline.presentation.ui.sign_up

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.lifeline.R
import com.example.lifeline.databinding.SignUpPersonalFragmentBinding
import com.example.lifeline.presentation.BaseFragment
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class SignUpPersonalFragment : BaseFragment() {
    private lateinit var binding: SignUpPersonalFragmentBinding
    private val viewModel: SignUpViewModel by sharedViewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.sign_up_fragment, container, false)
        binding.btnNext.setOnClickListener {
            viewModel.savePersonal(
                binding.etFullName.text.toString(),
                binding.etAddress.text.toString(),
                binding.etPolicy.text.toString()
            )
        }
        return binding.root
    }
}