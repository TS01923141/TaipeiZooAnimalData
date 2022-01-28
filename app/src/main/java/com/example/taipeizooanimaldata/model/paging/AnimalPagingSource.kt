package com.example.taipeizooanimaldata.model.paging

import android.util.Log
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.taipeizooanimaldata.model.network.AnimalDataEntity
import com.example.taipeizooanimaldata.model.repository.ZooRepository
import javax.inject.Inject

private const val TAG = "AnimalPagingSource"

class AnimalPagingSource @Inject constructor(private val zooRepository: ZooRepository) :
    PagingSource<Int, AnimalDataEntity>() {
    override fun getRefreshKey(state: PagingState<Int, AnimalDataEntity>): Int? {
        // Try to find the page key of the closest page to anchorPosition, from
        // either the prevKey or the nextKey, but you need to handle nullability
        // here:
        //  * prevKey == null -> anchorPage is the first page.
        //  * nextKey == null -> anchorPage is the last page.
        //  * both prevKey and nextKey null -> anchorPage is the initial page, so
        //    just return null.
        return state.anchorPosition?.let {
            val anchorPage = state.closestPageToPosition(it)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }

    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, AnimalDataEntity> {
        Log.d(TAG, "load: params.key: ${params.key}")
        val nextPageNumber = params.key ?: 0
        val response =
            zooRepository.getAnimalDataList("", params.loadSize, nextPageNumber * params.loadSize)
        return try {
            LoadResult.Page(
                data = response?.result!!.results,
                prevKey = if (nextPageNumber <= 0) null else nextPageNumber - 1,
                nextKey = nextPageNumber + 1
            )
        } catch (e: Exception) {
            e.printStackTrace()
            LoadResult.Error(e)
        }
    }
}