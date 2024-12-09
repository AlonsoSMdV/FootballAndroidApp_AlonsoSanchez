package com.example.footballandroidapp.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.footballandroidapp.data.models.players.Player
import com.example.footballandroidapp.databinding.PlayerItemBinding
import com.example.footballandroidapp.ui.fragment.PlayerListFragmentDirections
import com.example.footballandroidapp.ui.viewModel.PlayerListViewModel

class PlayerListAdapter(private val viewModel: PlayerListViewModel, private val idTeam: Int): ListAdapter<Player, PlayerListAdapter.PlayerViewHolder>(DiffCallback()) {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): PlayerViewHolder {
        val binding = PlayerItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PlayerViewHolder(binding, viewModel, idTeam)
    }

    override fun onBindViewHolder(holder: PlayerViewHolder, position: Int) {
        val player = getItem(position)
        holder.bind(player)
    }

    class PlayerViewHolder(private val binding: PlayerItemBinding, private val viewModel: PlayerListViewModel, private val idTeam: Int): RecyclerView.ViewHolder(binding.root){
        fun bind(player: Player){
            binding.playerName.text = player.name
            binding.deletePlayerButton.setOnClickListener {
                viewModel.deletePlayer(player.id.toInt(), idTeam)
            }

            binding.playerCard.setOnClickListener {
                val action = PlayerListFragmentDirections.playersToDetails(player.id.toInt())
                it.findNavController().navigate(action)
            }
        }
    }

    class DiffCallback: DiffUtil.ItemCallback<Player>(){
        override fun areItemsTheSame(oldItem: Player, newItem: Player): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Player, newItem: Player): Boolean {
            return oldItem == newItem
        }

    }

}