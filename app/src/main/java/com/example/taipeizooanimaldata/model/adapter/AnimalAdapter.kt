package com.example.taipeizooanimaldata.model.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.taipeizooanimaldata.databinding.ListItemAnimalBinding
import com.example.taipeizooanimaldata.model.network.AnimalDataEntity

class AnimalAdapter : ListAdapter<AnimalDataEntity, RecyclerView.ViewHolder>(AnimalDiffCallback()){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return AnimalViewHolder(
            ListItemAnimalBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val animalData = getItem(position)
        (holder as AnimalViewHolder).bind(animalData)
    }

    class AnimalViewHolder(private val binding: ListItemAnimalBinding): RecyclerView.ViewHolder(binding.root) {
        init {
            binding.setClickListener {

            }
        }
        fun bind(item: AnimalDataEntity) {
            binding.apply {
                animalData = item
                //更新畫面
                executePendingBindings()
            }
        }
    }
}

private class AnimalDiffCallback: DiffUtil.ItemCallback<AnimalDataEntity>() {
    override fun areItemsTheSame(oldItem: AnimalDataEntity, newItem: AnimalDataEntity): Boolean {
        return oldItem._id == newItem._id
    }

    override fun areContentsTheSame(oldItem: AnimalDataEntity, newItem: AnimalDataEntity): Boolean {
        return oldItem == newItem
    }

}