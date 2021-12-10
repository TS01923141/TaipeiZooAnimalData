package com.example.taipeizooanimaldata.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.taipeizooanimaldata.model.network.AnimalDataEntity
import dagger.hilt.android.lifecycle.HiltViewModel

//@HiltViewModel
class DetailViewModel: ViewModel() {
    private var _animalDataEntity: MutableLiveData<AnimalDataEntity> = MutableLiveData()
    val animalDataEntity: LiveData<AnimalDataEntity> = _animalDataEntity

    fun setAnimalDataEntity(animalDataEntity: AnimalDataEntity?) {
        if (animalDataEntity == null) return
        _animalDataEntity.value = animalDataEntity
    }
}