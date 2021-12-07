package com.example.taipeizooanimaldata.model.database

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.taipeizooanimaldata.model.network.AnimalDataEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface AnimalDataDao {
    @Query("select * from AnimalDataEntity")
    fun getAnimalDataList() : Flow<List<AnimalDataEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(animalDataEntityList: List<AnimalDataEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(animalDataEntity: AnimalDataEntity)

    @Delete
    fun delete(animalDataEntity: AnimalDataEntity)
}