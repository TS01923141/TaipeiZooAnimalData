package com.example.taipeizooanimaldata.ui.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.taipeizooanimaldata.model.repository.ZooRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val repository: ZooRepository): ViewModel() {

    val animalDataList by lazy {repository.animalDataEntityList}

    fun refreshAnimalList(query: String? = null , limit: Int? = null, offset: Int? = null) = viewModelScope.launch {
        repository.refreshAnimalDataList(query, limit, offset)
    }
}