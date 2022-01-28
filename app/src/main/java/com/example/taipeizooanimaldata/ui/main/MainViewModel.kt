package com.example.taipeizooanimaldata.ui.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingSource
import androidx.paging.cachedIn
import com.example.taipeizooanimaldata.model.paging.AnimalPagingSource
import com.example.taipeizooanimaldata.model.repository.ZooRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val repository: ZooRepository, private val animalPagingSource: AnimalPagingSource): ViewModel() {
    val animalFlow = Pager(
        // Configure how data is loaded by passing additional properties to
        // PagingConfig, such as prefetchDistance.
        PagingConfig(pageSize = 20)
    ) { animalPagingSource }.flow.cachedIn(viewModelScope)

    val animalDataList by lazy {repository.animalDataEntityList}

    fun refreshAnimalList(query: String? = null , limit: Int? = null, offset: Int? = null) = viewModelScope.launch {
        repository.refreshAnimalDataList(query, limit, offset)
    }
}