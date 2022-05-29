package com.example.lifeline.presentation.ui.sign_up

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.lifeline.R
import com.example.lifeline.data.utils.DataConstants
import com.example.lifeline.databinding.SignUpParametersFragmentBinding
import com.example.lifeline.presentation.BaseFragment
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class SignUpParametersFragment : BaseFragment() {
    private lateinit var binding: SignUpParametersFragmentBinding
    private val viewModel: SignUpViewModel by sharedViewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.sign_up_parameters_fragment,
            container,
            false
        )
        binding.btnNext.setOnClickListener {
            viewModel.saveParameters(
                binding.etBirthdate.text.toString(),
                if (binding.cbMaleGender.isChecked) DataConstants.male else DataConstants.female,
                binding.etHeight.text.toString(),
                binding.etWeight.text.toString()
            )
        }
        return binding.root
    }
}