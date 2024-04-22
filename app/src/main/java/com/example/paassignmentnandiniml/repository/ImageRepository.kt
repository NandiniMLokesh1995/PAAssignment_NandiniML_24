package com.example.paassignmentnandiniml.repository

import androidx.paging.*
import androidx.room.withTransaction
import com.example.paassignmentnandiniml.entities.CoverageItemEntity
import com.example.paassignmentnandiniml.network.ApiService
import com.example.paassignmentnandiniml.network.AppDatabase
import kotlinx.coroutines.flow.*

@OptIn(ExperimentalPagingApi::class)
class ImageRepository(private val apiService: ApiService, private val appDatabase: AppDatabase) {

    private var currentPage = 300
    fun getItems(): Flow<PagingData<CoverageItemEntity>> {

        //val pagingSourceFactory =appDatabase.imageDao().itemsByPage()
        return Pager(
                config = PagingConfig(
                    pageSize = 30,
                    prefetchDistance = 5,      // Fetch the next page 5 items before the list end
                    enablePlaceholders = true
                ),
                pagingSourceFactory = { appDatabase.imageDao().itemsByPage() }
            ).flow
        }


    suspend fun refreshData() {
        val response = apiService.fetchItems(currentPage) // Make network request
        appDatabase.withTransaction {
            appDatabase.imageDao().insert(response)
        }
    }
}
