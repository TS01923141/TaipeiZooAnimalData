package com.example.taipeizooanimaldata.model.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.core.os.bundleOf
import androidx.core.view.ViewCompat
import androidx.navigation.findNavController
import androidx.navigation.fragment.FragmentNavigatorExtras
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.taipeizooanimaldata.R
import com.example.taipeizooanimaldata.databinding.ListItemAnimalBinding
import com.example.taipeizooanimaldata.model.network.AnimalDataEntity
import com.example.taipeizooanimaldata.ui.main.MainActivity

private const val TAG = "AnimalAdapter"
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
            binding.setClickListener { view ->
                binding.animalData?.let { animalDataEntity ->
                    navigationToDetail(animalDataEntity, view)
                }
            }
        }

        private fun navigationToDetail(animalDataEntity: AnimalDataEntity, view: View) {
            val imageView = view.findViewById<ImageView>(R.id.imageView_item_animal)
            val extras = FragmentNavigatorExtras(imageView to (binding.animalData?._id?: ""))
            view.findNavController().navigate(
                R.id.detailFragment,
                bundleOf("animalData" to animalDataEntity),
                null,
                extras)
        }

        fun bind(item: AnimalDataEntity) {
            binding.apply {
                animalData = item
                //更新畫面
                executePendingBindings()
                //轉場動畫對象
                //要注意的是每個動畫對象的TransitionName要是unique，所以不能在xml設定因為會重複
                //重複的情況下雖然除move外都能正常執行，但有機率是錯誤的item做轉場
                ViewCompat.setTransitionName(imageViewItemAnimal, binding.animalData?._id)
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