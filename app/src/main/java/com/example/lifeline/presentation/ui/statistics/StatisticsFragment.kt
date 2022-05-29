package com.example.lifeline.presentation.ui.statistics

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.lifeline.R
import com.example.lifeline.data.utils.DataConstants
import com.example.lifeline.databinding.StatisticsFragmentBinding
import com.example.lifeline.entities.ChartData
import com.example.lifeline.presentation.BaseFragment
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class StatisticsFragment : BaseFragment() {
    private lateinit var binding: StatisticsFragmentBinding
    private val viewModel: StatisticsViewModel by sharedViewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.profile_fragment, container, false)
        binding.run {
            lifecycleOwner = viewLifecycleOwner
            viewModel.setupChart(binding.chartPressure, ChartData(title = resources.getString(R.string.pressure), DataConstants.emptyString))

            viewModel.getData()
        }
        return binding.root
    }
}