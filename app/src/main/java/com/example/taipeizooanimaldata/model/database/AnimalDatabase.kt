package com.example.taipeizooanimaldata.model.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.taipeizooanimaldata.model.network.AnimalDataEntity

@Database(entities = [AnimalDataEntity::class], version = 1)
abstract class AnimalDatabase: RoomDatabase() {
    abstract val animalDataDao: AnimalDataDao
}