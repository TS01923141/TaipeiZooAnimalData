package com.example.taipeizooanimaldata.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.example.taipeizooanimaldata.R
import com.example.taipeizooanimaldata.databinding.ActivityMainBinding
import com.example.taipeizooanimaldata.model.adapter.AnimalAdapter
import dagger.hilt.android.AndroidEntryPoint


/*
    這次要導入
    DataBinding
    Flow
    PagingDataAdapter
    Navigation

    systemBar瀏海改成透明

    navigation跳到detailActivity
 */

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val viewModel: MainViewModel by viewModels()
    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val adapter = AnimalAdapter()
        binding.recyclerViewMain.adapter = adapter

        with(viewModel) {
            animalDataList.observe(this@MainActivity, adapter::submitList)
        }
    }

    override fun onResume() {
        super.onResume()
        viewModel.refreshAnimalList()
    }
}