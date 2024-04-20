package com.example.paassignmentnandiniml.network

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.paassignmentnandiniml.entities.CoverageItemEntity

@Dao
interface ImageDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(item: List<CoverageItemEntity>)

    @Query("SELECT * FROM coverage_items")
    fun itemsByPage(): PagingSource<Int, CoverageItemEntity>
}