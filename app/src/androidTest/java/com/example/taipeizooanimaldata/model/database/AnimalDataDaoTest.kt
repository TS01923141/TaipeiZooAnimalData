package com.example.taipeizooanimaldata.model.database

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.room.Room
import androidx.test.platform.app.InstrumentationRegistry
import com.example.taipeizooanimaldata.model.network.AnimalDataEntity
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class AnimalDataDaoTest {
    private lateinit var database: AnimalDatabase
    private lateinit var animalDataDao: AnimalDataDao
//    private

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Before fun createDb() = runBlocking {
        val context = InstrumentationRegistry.getInstrumentation().targetContext
        database = Room.inMemoryDatabaseBuilder(context, AnimalDatabase::class.java).build()
        //test this
        animalDataDao = database.animalDataDao
    }

    @After fun closeDb() {
        database.close()
    }

    @Test fun testGetAnimalDataList() = runBlocking {
        val animalDataEntity = AnimalDataEntity.empty
        animalDataDao.insert(animalDataEntity)
        assertEquals(animalDataDao.getAnimalDataList().first().size , 1)
    }

    @Test fun testDeleteAnimalEntity() = runBlocking {
        val animalDataEntity = AnimalDataEntity.empty
        animalDataDao.insert(animalDataEntity)
        assertEquals(animalDataDao.getAnimalDataList().first().size, 1)
        animalDataDao.delete(animalDataEntity)
        assertEquals(animalDataDao.getAnimalDataList().first().size , 0)
    }
}