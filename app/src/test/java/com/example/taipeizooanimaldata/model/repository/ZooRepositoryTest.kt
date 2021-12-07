package com.example.taipeizooanimaldata.model.repository

import com.example.taipeizooanimaldata.model.database.AnimalDatabase
import com.example.taipeizooanimaldata.model.network.AnimalDataEntity
import com.example.taipeizooanimaldata.model.network.AnimalDataResponse
import com.example.taipeizooanimaldata.model.network.ZooService
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.MockK
import kotlinx.coroutines.runBlocking
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import java.net.UnknownHostException

class ZooRepositoryTest() {
    private lateinit var zooRepository: ZooRepository

    @MockK private lateinit var service: ZooService
    @MockK private lateinit var database: AnimalDatabase

    private val query = null
    private val limit = null
    private val offset = null

    @Before
    fun setUp(){
        MockKAnnotations.init(this)
        zooRepository = ZooRepository(service, database)
    }

    @Test
    fun `should return null when throws UnknownHostException`() {
        coEvery { service.getAnimalData(query, limit, offset) } throws UnknownHostException()
        runBlocking {
            val animalDataEntity = zooRepository.getAnimalDataList(query, limit, offset)
            assertEquals(animalDataEntity, null)
        }
    }

    @Test
    fun `should return null when response not sucessful`() {
        coEvery { service.getAnimalData(query, limit, offset).isSuccessful } returns false
        runBlocking {
            val animalDataEntity = zooRepository.getAnimalDataList(query, limit, offset)
            assertEquals(animalDataEntity, null)
        }
    }

    @Test
    fun `should return AnimalDataEntity from service`() {
        coEvery { service.getAnimalData(query, limit, offset).isSuccessful } returns true
        coEvery { service.getAnimalData(query, limit, offset).body() } returns AnimalDataResponse.empty
        runBlocking {
            val animalDataEntity = zooRepository.getAnimalDataList(query, limit, offset)
            assertEquals(animalDataEntity, AnimalDataResponse.empty)
        }
    }
}