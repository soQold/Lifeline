package com.example.lifeline.presentation.ui.diary

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import com.example.lifeline.R
import com.example.lifeline.databinding.DiaryFragmentBinding
import com.example.lifeline.presentation.BaseFragment
import com.example.lifeline.presentation.ui.DefaultViewModel
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class DiaryFragment : BaseFragment() {
    private lateinit var binding: DiaryFragmentBinding
    private val defaultViewModel: DefaultViewModel by sharedViewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        defaultViewModel.title.postValue(getString(R.string.app_name))
        binding = DataBindingUtil.inflate(inflater, R.layout.diary_fragment, container, false)
        binding.lifecycleOwner = viewLifecycleOwner

        binding.run {
            btnFillData.setOnClickListener {
                Navigation.findNavController(it)
                    .navigate(R.id.action_diary_fragment_to_fill_fragment)
            }
            btnStatistics.setOnClickListener {
                Navigation.findNavController(it)
                    .navigate(R.id.action_diary_fragment_to_statistics_fragment)
            }
            btnUserActivity.setOnClickListener {
                Navigation.findNavController(it)
                    .navigate(R.id.action_diary_fragment_to_user_activity_fragment)
            }
            return binding.root
        }
    }
}