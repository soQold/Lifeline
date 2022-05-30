package com.example.lifeline.presentation.ui.statistics

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.lifeline.R
import com.example.lifeline.databinding.StatisticsFragmentBinding
import com.example.lifeline.entities.ChartData
import com.example.lifeline.presentation.BaseFragment
import com.example.lifeline.utils.ChartDateFormatter
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class StatisticsFragment : BaseFragment() {
    private lateinit var binding: StatisticsFragmentBinding
    private val viewModel: StatisticsViewModel by sharedViewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.statistics_fragment, container, false)
        binding.run {
            lifecycleOwner = viewLifecycleOwner
            viewModel.setupChart(
                binding.chartPressure,
                ChartData(
                    title = getString(R.string.pressure),
                    lineTitle = getString(R.string.pressureSys),
                    secondLineTitle = getString(R.string.pressureDia)
                )
            )
            viewModel.setupChart(
                binding.chartPulse,
                ChartData(title = getString(R.string.pulse), lineTitle = getString(R.string.pulse))
            )

//            viewModel.getData()
            //TEST ONLY
            viewModel.mockData()

            viewModel.pressureLiveData.observe(viewLifecycleOwner){
                viewModel.setupChart(
                    chartPressure,
                    ChartData(
                        title = getString(R.string.pressure),
                        lineTitle = getString(R.string.pressureSys),
                        secondLineTitle = getString(R.string.pressureDia),
                        valueFormatterX =  ChartDateFormatter(),
                        values = it
                    )
                )
            }
            viewModel.pulseLiveData.observe(viewLifecycleOwner){
                viewModel.setupChart(
                    chartPulse,
                    ChartData(
                        title = getString(R.string.pulse),
                        lineTitle = getString(R.string.pulse),
                        valueFormatterX =  ChartDateFormatter(),
                        values = it
                    )
                )
            }
        }
        return binding.root
    }
}