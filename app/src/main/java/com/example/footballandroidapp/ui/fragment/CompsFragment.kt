package com.example.footballandroidapp.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.example.footballandroidapp.ui.viewModel.CompListUiState
import com.example.footballandroidapp.ui.viewModel.CompetitionViewModel
import com.example.footballandroidapp.R
import com.example.footballandroidapp.databinding.FragmentCompetitionListBinding
import com.example.footballandroidapp.ui.adapter.CompetitionListAdapter
import com.google.android.material.floatingactionbutton.FloatingActionButton
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class CompsFragment : Fragment(R.layout.fragment_competition_list) {
    private lateinit var binding: FragmentCompetitionListBinding
    private val viewModel: CompetitionViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCompetitionListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = CompetitionListAdapter(viewModel)
        binding.compList.adapter = adapter

        binding.compList.layoutManager = GridLayoutManager(requireContext(), 2)

        val btnToCreate = view.findViewById<FloatingActionButton>(R.id.button_to_create_comp)
        btnToCreate.setOnClickListener {
            findNavController().navigate(R.id.comps_to_create)
        }

        lifecycleScope.launch {
            viewModel.uiState.collect { uiState ->
                when (uiState) {
                    CompListUiState.Loading -> {
                    }
                    is CompListUiState.Success -> {
                        adapter.submitList(uiState.compList)
                    }
                    is CompListUiState.Error -> {
                    }
                }
            }
        }
    }
}