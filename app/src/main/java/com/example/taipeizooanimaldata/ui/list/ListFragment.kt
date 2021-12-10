package com.example.taipeizooanimaldata.ui.list

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.example.taipeizooanimaldata.R
import com.example.taipeizooanimaldata.databinding.FragmentListBinding
import com.example.taipeizooanimaldata.model.adapter.AnimalAdapter
import com.example.taipeizooanimaldata.ui.main.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.HiltAndroidApp

private const val TAG = "ListFragment"
@AndroidEntryPoint
class ListFragment : Fragment() {
    private lateinit var binding : FragmentListBinding
    private val viewModel: MainViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentListBinding.inflate(layoutInflater, container, false)

        val adapter = AnimalAdapter()
        binding.recyclerViewMain.adapter = adapter

        with(viewModel) {
            animalDataList.observe(this@ListFragment, adapter::submitList)
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //接收轉場返回效果
        binding.recyclerViewMain.apply {
            postponeEnterTransition()
            viewTreeObserver
                .addOnPreDrawListener {
                    startPostponedEnterTransition()
                    true
                }
        }
    }
}