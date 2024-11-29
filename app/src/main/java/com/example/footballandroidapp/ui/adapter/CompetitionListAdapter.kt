package com.example.footballandroidapp.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.footballandroidapp.data.models.comps.Competition
import com.example.footballandroidapp.databinding.CompetitionItemBinding

class CompetitionListAdapter: ListAdapter<Competition, CompetitionListAdapter.CompetitionViewHolder>(DiffCallback()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CompetitionViewHolder {
        val binding = CompetitionItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CompetitionViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CompetitionViewHolder, position: Int) {
        val competition = getItem(position)
        holder.bind(competition)
    }

    class CompetitionViewHolder(private val binding: CompetitionItemBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(competition: Competition) {
            binding.compName.text = competition.name
        }
    }

    class DiffCallback : DiffUtil.ItemCallback<Competition>() {
        override fun areItemsTheSame(oldItem: Competition, newItem: Competition): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Competition, newItem: Competition): Boolean {
            return oldItem == newItem
        }
    }
}