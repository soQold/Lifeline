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
import com.example.lifeline.utils.StringValidator
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
            etPressureSys.doAfterTextChanged {
                viewModel.pressureSysLiveData.postValue(it.toString())
            }
            etPressureDia.doAfterTextChanged {
                viewModel.pressureDiaLiveData.postValue(it.toString())
            }
            etSleep.doAfterTextChanged {
                viewModel.sleepLiveData.postValue(it.toString())
            }
            etTemperature.doAfterTextChanged {
                viewModel.temperatureLiveData.postValue(it.toString())
            }
            btnConfirm.setOnClickListener { viewModel.saveData() }


            viewModel.pulseLiveData.observe(viewLifecycleOwner){
                if(it.isNotEmpty() && !StringValidator.validatePulse(it)){
                    etLayoutPulse.isErrorEnabled = true
                    etLayoutPulse.error = getString(R.string.value_error_pulse)
                }
                else{
                    etLayoutPulse.isErrorEnabled = false
                }
            }

            viewModel.pressureSysLiveData.observe(viewLifecycleOwner){
                if(it.isNotEmpty() && !StringValidator.validatePressureSys(it)){
                    etLayoutPressureSys.isErrorEnabled = true
                    etLayoutPressureSys.error = getString(R.string.value_error_pressure_sys)
                }
                else{
                    etLayoutPressureSys.isErrorEnabled = false
                }
            }

            viewModel.pressureDiaLiveData.observe(viewLifecycleOwner){
                if(it.isNotEmpty() && !StringValidator.validatePressureSys(it)){
                    etLayoutPressureDia.isErrorEnabled = true
                    etLayoutPressureDia.error = getString(R.string.value_error_pressure_dia)
                }
                else{
                    etLayoutPressureDia.isErrorEnabled = false
                }
            }
        }
        return binding.root
    }
}