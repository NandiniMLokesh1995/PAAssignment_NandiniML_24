/*
package com.example.paassignmentnandiniml.repository

import androidx.paging.*
import androidx.room.withTransaction
import coil.network.HttpException
import com.example.paassignmentnandiniml.entities.CoverageItemEntity
import com.example.paassignmentnandiniml.network.ApiService
import com.example.paassignmentnandiniml.network.AppDatabase
import java.io.IOException

@OptIn(ExperimentalPagingApi::class)
class ItemRemoteMediator(
    private val apiService: ApiService,
    private val database: AppDatabase
) : RemoteMediator<Int, CoverageItemEntity>() {

    private val imageDao = database.imageDao()
    private var currentPage = 300// Start with first page

    override suspend fun load(
        loadType: LoadType,
        state: PagingState<Int, CoverageItemEntity>
    ): MediatorResult {
        try {
            val pageKey = currentPage
            val response = apiService.fetchItems(pageKey)
            val endOfPaginationReached = response.isEmpty()

            database.withTransaction {
                imageDao.insert(response)
            }
            currentPage = pageKey + 10
            return MediatorResult.Success(endOfPaginationReached = endOfPaginationReached)
        } catch (e: IOException) {
            return MediatorResult.Error(e)
        } catch (e: HttpException) {
            return MediatorResult.Error(e)
        }
    }
}

*/
