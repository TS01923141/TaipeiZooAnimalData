package com.example.taipeizooanimaldata.model.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.asLiveData
import com.example.taipeizooanimaldata.model.database.AnimalDatabase
import com.example.taipeizooanimaldata.model.network.AnimalDataEntity
import com.example.taipeizooanimaldata.model.network.AnimalDataResponse
import com.example.taipeizooanimaldata.model.network.ZooService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.net.SocketTimeoutException
import java.net.UnknownHostException
import javax.inject.Inject
import javax.net.ssl.SSLHandshakeException

class ZooRepository @Inject constructor(private val service: ZooService, private val database: AnimalDatabase) {
    var animalDataEntityList: LiveData<List<AnimalDataEntity>> = database.animalDataDao.getAnimalDataList().asLiveData()

    suspend fun refreshAnimalDataList(query: String?, limit: Int?, offset: Int?) = withContext(Dispatchers.IO) {
        val response = getAnimalDataList(query, limit, offset) ?: return@withContext
        database.animalDataDao.insertAll(response.result.results)
    }

    suspend fun getAnimalDataList(query: String?, limit: Int?, offset: Int?) : AnimalDataResponse? =
        try {
            val response = service.getAnimalData(query, limit, offset)
            if (response.isSuccessful) {
                response.body()
            } else {
                null
            }
        } catch (e: UnknownHostException) {
            e.printStackTrace()
            null
        } catch (e: SocketTimeoutException) {
            e.printStackTrace()
            null
        } catch (e: SSLHandshakeException) {
            e.printStackTrace()
            null
        }
}