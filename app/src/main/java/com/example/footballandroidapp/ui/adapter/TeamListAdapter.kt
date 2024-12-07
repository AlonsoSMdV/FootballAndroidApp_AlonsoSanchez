package com.example.footballandroidapp.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.footballandroidapp.data.models.teams.Team
import com.example.footballandroidapp.databinding.TeamItemBinding
import com.example.footballandroidapp.ui.fragment.CompsFragmentDirections
import com.example.footballandroidapp.ui.fragment.TeamFragmentDirections

class TeamListAdapter: ListAdapter<Team, TeamListAdapter.TeamViewHolder>(DiffCallback()) {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): TeamViewHolder {
        val binding = TeamItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TeamViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TeamViewHolder, position: Int) {
        val team = getItem(position)
        holder.bind(team)
    }

    class TeamViewHolder(private val binding: TeamItemBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(team: Team){
            binding.teamName.text = team.name

            binding.teamCard.setOnClickListener {
                val action = TeamFragmentDirections.teamsToPlayers(team.id.toInt())
                it.findNavController().navigate(action)
            }
        }
    }

    class DiffCallback: DiffUtil.ItemCallback<Team>(){
        override fun areItemsTheSame(oldItem: Team, newItem: Team): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Team, newItem: Team): Boolean {
            return oldItem == newItem
        }

    }

}