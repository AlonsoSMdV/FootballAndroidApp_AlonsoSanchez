package com.example.footballandroidapp.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.example.footballandroidapp.R
import com.example.footballandroidapp.databinding.FragmentCompetitionListBinding
import com.example.footballandroidapp.databinding.FragmentTeamListBinding
import com.example.footballandroidapp.ui.adapter.CompetitionListAdapter
import com.example.footballandroidapp.ui.adapter.TeamListAdapter
import com.example.footballandroidapp.ui.viewModel.CompListUiState
import com.example.footballandroidapp.ui.viewModel.TeamListUiState
import com.example.footballandroidapp.ui.viewModel.TeamViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class TeamFragment: Fragment(R.layout.fragment_team_list) {
    private lateinit var binding: FragmentTeamListBinding
    private val viewModel: TeamViewModel by viewModels()
    private var idComp: Int? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTeamListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        idComp = arguments?.getInt("idComp")
        binding = FragmentTeamListBinding.bind(view)


        binding.teamsToolbar.apply {
            setNavigationOnClickListener {
                findNavController().navigateUp()
            }
        }

        val adapter = TeamListAdapter()
        binding.teamList.adapter = adapter



        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.observeTeamsByLeague(idComp!!)
            }
        }

        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.uiState.collect { uiState ->
                    when (uiState) {
                        TeamListUiState.Loading -> {
                        }

                        is TeamListUiState.Success -> {
                            adapter.submitList(uiState.teamList)
                        }

                        is TeamListUiState.Error -> {
                        }
                    }
                }
            }
        }
    }
}