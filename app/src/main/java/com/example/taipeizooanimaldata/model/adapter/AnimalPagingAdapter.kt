package com.example.taipeizooanimaldata.model.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.core.os.bundleOf
import androidx.core.view.ViewCompat
import androidx.navigation.findNavController
import androidx.navigation.fragment.FragmentNavigatorExtras
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.taipeizooanimaldata.R
import com.example.taipeizooanimaldata.databinding.ListItemAnimalBinding
import com.example.taipeizooanimaldata.model.network.AnimalDataEntity

private const val TAG = "AnimalPagingAdapter"
class AnimalPagingAdapter : PagingDataAdapter<AnimalDataEntity, RecyclerView.ViewHolder>(AnimalDiffCallback()){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return AnimalViewHolder(
            ListItemAnimalBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val animalData = getItem(position)
        if (animalData != null) (holder as AnimalViewHolder).bind(animalData)
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
                //????????????
                executePendingBindings()
                //??????????????????
                //????????????????????????????????????TransitionName??????unique??????????????????xml?????????????????????
                //???????????????????????????move????????????????????????????????????????????????item?????????
                ViewCompat.setTransitionName(imageViewItemAnimal, binding.animalData?._id)
            }
        }
    }
}