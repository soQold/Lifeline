package com.example.lifeline.presentation.ui.fill

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.doAfterTextChanged
import androidx.databinding.DataBindingUtil
import com.example.lifeline.R
import com.example.lifeline.databinding.FillFragmentBinding
import com.example.lifeline.presentation.BaseFragment
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class FillFragment : BaseFragment() {
    private lateinit var binding: FillFragmentBinding
    private val viewModel: FillViewModel by sharedViewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fill_fragment, container, false)
        binding.run {
            lifecycleOwner = viewLifecycleOwner
            model = viewModel

            etPulse.doAfterTextChanged {
                viewModel.pulseLiveData.postValue(it.toString())
            }
            etPressure.doAfterTextChanged {
                viewModel.pressureLiveData.postValue(it.toString())
            }
            etSleep.doAfterTextChanged {
                viewModel.sleepLiveData.postValue(it.toString())
            }
            etTemperature.doAfterTextChanged {
                viewModel.temperatureLiveData.postValue(it.toString())
            }
            btnConfirm.setOnClickListener { viewModel.saveData() }
        }
        return binding.root
    }
}