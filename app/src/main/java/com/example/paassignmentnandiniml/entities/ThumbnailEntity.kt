package com.example.paassignmentnandiniml.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.serialization.Serializable

@Entity(tableName = "thumbnail")
@Serializable
data class ThumbnailEntity(
    @PrimaryKey
    @ColumnInfo(name = "id")
    val id: String,
    @ColumnInfo(name = "version")
    val version: Int,
    @ColumnInfo(name = "domain")
    val domain: String,
    @ColumnInfo(name = "basePath")
    val basePath: String,
    @ColumnInfo(name = "key")
    val key: String,
    @ColumnInfo(name = "qualities")
    val qualities: List<Int>
)
