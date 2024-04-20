package com.example.paassignmentnandiniml.repository

import android.net.http.HttpException
import androidx.paging.*
import androidx.room.withTransaction
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
    private var currentPage = 10// Start with first page

    override suspend fun load(loadType: LoadType, state: PagingState<Int, CoverageItemEntity>): MediatorResult {
        try {
            val pageKey = when (loadType) {
                LoadType.REFRESH -> 1
                LoadType.PREPEND -> return MediatorResult.Success(endOfPaginationReached = true) // Data loaded in order, no prepend
                LoadType.APPEND -> {
                    val lastItem = state.lastItemOrNull() ?: return MediatorResult.Success(endOfPaginationReached = true)
                    currentPage + 10
                }
            }

            val response = apiService.fetchItems(pageKey)
            val endOfPaginationReached = response.isEmpty()

            database.withTransaction {
                if (loadType == LoadType.REFRESH) {
                    //imageDao.clearAll() // Optional: Clear all items in the table if refreshing
                }
                imageDao.insert(response)
            }
            currentPage = pageKey
            return MediatorResult.Success(endOfPaginationReached = endOfPaginationReached)
        } catch (e: IOException) {
            return MediatorResult.Error(e)
        } catch (e: HttpException) {
            return MediatorResult.Error(e)
        }
    }


}
