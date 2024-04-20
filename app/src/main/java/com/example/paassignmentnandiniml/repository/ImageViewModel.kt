package com.example.paassignmentnandiniml.repository

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.PagingSource
import androidx.paging.PagingState
import androidx.paging.cachedIn
import com.example.paassignmentnandiniml.entities.CoverageItemEntity
import com.example.paassignmentnandiniml.network.ApiService
import io.ktor.client.request.*
import kotlinx.coroutines.flow.Flow
import com.example.paassignmentnandiniml.entities.Util


class ImageViewModel(private val repository: ImageRepository) : ViewModel() {
    val items: Flow<PagingData<CoverageItemEntity>> = repository.getItems().cachedIn(viewModelScope)
}

