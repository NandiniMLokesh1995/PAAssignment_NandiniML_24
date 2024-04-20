package com.example.paassignmentnandiniml.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.serialization.Serializable

@Entity(tableName = "coverage_items")
@Serializable
data class CoverageItemEntity(
    @PrimaryKey
    @ColumnInfo(name = "id")
    val id: String,
    @ColumnInfo(name = "title")
    val title: String,
    @ColumnInfo(name = "language")
    val language: String,
    @ColumnInfo(name = "thumbnail")
    val thumbnail: ThumbnailEntity
)

