package com.example.footballandroidapp.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.example.footballandroidapp.R
import com.example.footballandroidapp.data.models.players.IPlayerRepository
import com.example.footballandroidapp.data.models.players.Player
import com.example.footballandroidapp.databinding.FragmentPlayerListBinding
import com.example.footballandroidapp.databinding.FragmentPlayersDetailBinding
import com.example.footballandroidapp.ui.adapter.PlayerListAdapter
import com.example.footballandroidapp.ui.viewModel.PlayerDetailsViewModel
import com.example.footballandroidapp.ui.viewModel.PlayerListUiState
import com.example.footballandroidapp.ui.viewModel.PlayerListViewModel
import com.google.android.material.floatingactionbutton.FloatingActionButton
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@AndroidEntryPoint
class PlayerDetailsFragment: Fragment(R.layout.fragment_players_detail) {
    private lateinit var binding: FragmentPlayersDetailBinding
    private lateinit var  viewModel: PlayerDetailsViewModel

    private var playerId: Int? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPlayersDetailBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this).get(PlayerDetailsViewModel::class.java)
        playerId = arguments?.getInt("idPlayer")
        viewModel.getPlayerDetails(playerId!!)
        viewModel.player.observe(viewLifecycleOwner, Observer { player ->
            getPlayer(player)
        })


    }

    private fun getPlayer(player: Player){
        binding.playerName.text = player.name ?: "Nombre no disponible"
        binding.playerFirstSurname.text = player.firstSurname ?: "Apellido no disponible"
        binding.playerSecondSurname.text = player.secondSurname ?: "Segundo apellido no disponible"
        binding.playerNationality.text = player.nationality ?: "Nacionalidad no disponible"
        binding.playerDorsal.text = player.dorsal.toString() ?: "Dorsal no disponible"
        binding.playerBirthdate.text = player.birthdate ?: "Fecha de nacimiento no disponible"
        binding.playerPosition.text = player.position ?: "Posición no disponible"
    }
}