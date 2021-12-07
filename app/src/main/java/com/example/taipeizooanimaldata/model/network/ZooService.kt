package com.example.taipeizooanimaldata.model.network

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ZooService {
    @GET("a3e2b221-75e0-45c1-8f97-75acbd43d613?scope=resourceAquire")
    suspend fun getAnimalData(
        @Query("q") query: String?,
        @Query("limit") limit: Int?,
        @Query("offset") offset: Int?
        ): Response<AnimalDataResponse>
}