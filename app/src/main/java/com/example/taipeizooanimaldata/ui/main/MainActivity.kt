package com.example.taipeizooanimaldata.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.navigation.findNavController
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

    navigation跳到detailActivity
 */

private const val TAG = "MainActivity"
@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val viewModel: MainViewModel by viewModels()
    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onResume() {
        super.onResume()
        viewModel.refreshAnimalList()
    }
}