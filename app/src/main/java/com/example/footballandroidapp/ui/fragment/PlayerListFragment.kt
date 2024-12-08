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
import com.example.footballandroidapp.databinding.FragmentPlayerListBinding
import com.example.footballandroidapp.databinding.FragmentTeamListBinding
import com.example.footballandroidapp.ui.adapter.PlayerListAdapter
import com.example.footballandroidapp.ui.adapter.TeamListAdapter
import com.example.footballandroidapp.ui.viewModel.PlayerListUiState
import com.example.footballandroidapp.ui.viewModel.PlayerListViewModel
import com.example.footballandroidapp.ui.viewModel.TeamListUiState
import com.example.footballandroidapp.ui.viewModel.TeamViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class PlayerListFragment : Fragment(R.layout.fragment_player_list) {
    private lateinit var binding: FragmentPlayerListBinding
    private val viewModel: PlayerListViewModel by viewModels()
    private var idTeam: Int? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPlayerListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        idTeam = arguments?.getInt("idTeam")
        binding = FragmentPlayerListBinding.bind(view)


        binding.playersToolbar.apply {
            setNavigationOnClickListener {
                findNavController().navigate(R.id.players_to_teams)
            }
        }

        val adapter = PlayerListAdapter()
        binding.playerList.adapter = adapter

        binding.playerList.layoutManager = GridLayoutManager(requireContext(), 3)



        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.observePlayersByTeam(idTeam!!)
            }
        }

        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.uiState.collect { uiState ->
                    when (uiState) {
                        PlayerListUiState.Loading -> {
                        }

                        is PlayerListUiState.Success -> {
                            adapter.submitList(uiState.playerList)
                        }

                        is PlayerListUiState.Error -> {
                        }
                    }
                }
            }
        }
    }

}