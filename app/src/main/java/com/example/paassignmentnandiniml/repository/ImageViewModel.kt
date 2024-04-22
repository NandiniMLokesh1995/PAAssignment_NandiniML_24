package com.example.paassignmentnandiniml.repository

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.example.paassignmentnandiniml.entities.CoverageItemEntity
import com.example.paassignmentnandiniml.entities.NetworkConnection
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch


class ImageViewModel(private val repository: ImageRepository, val context: Context) : ViewModel() {

    private val _items = MutableLiveData<Flow<PagingData<CoverageItemEntity>>>()
    val items: LiveData<Flow<PagingData<CoverageItemEntity>>> = _items

    init {
        if(NetworkConnection(context).value == true){
            refreshData()
        }
        viewModelScope.launch {
            _items.value = repository.getItems().cachedIn(viewModelScope)
        }
    }

    fun refreshData() {
        viewModelScope.launch {
            repository.refreshData()
        }
    }
}

