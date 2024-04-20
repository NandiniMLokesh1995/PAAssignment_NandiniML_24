package com.example.paassignmentnandiniml.repository

import androidx.paging.*
import com.example.paassignmentnandiniml.entities.CoverageItemEntity
import com.example.paassignmentnandiniml.network.ApiService
import com.example.paassignmentnandiniml.network.AppDatabase
import com.example.paassignmentnandiniml.network.ImageDao
import kotlinx.coroutines.flow.*

@OptIn(ExperimentalPagingApi::class)
class ImageRepository(private val apiService: ApiService, private val appDatabase: AppDatabase) {

    fun getItems(): Flow<PagingData<CoverageItemEntity>> {
        return Pager(
            config = PagingConfig(
                pageSize = 100,
                enablePlaceholders = false
            ),
            remoteMediator = ItemRemoteMediator(apiService, appDatabase),
            pagingSourceFactory = { appDatabase.imageDao().itemsByPage() }
        ).flow
    }
}
