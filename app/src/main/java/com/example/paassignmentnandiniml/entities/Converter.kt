package com.example.paassignmentnandiniml.entities

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class Converter {
    @TypeConverter
    fun fromThumbnail(thumbnail: ThumbnailEntity?): String? {
        if (thumbnail == null) return null
        val gson = Gson()
        val type = object : TypeToken<ThumbnailEntity>() {}.type
        return gson.toJson(thumbnail, type)
    }

    @TypeConverter
    fun toThumbnail(thumbnailString: String?): ThumbnailEntity? {
        if (thumbnailString == null) return null
        val gson = Gson()
        val type = object : TypeToken<ThumbnailEntity>() {}.type
        return gson.fromJson(thumbnailString, type)
    }

    @TypeConverter
    fun fromIntegerList(qualities: List<Int>?): String? {
        if (qualities == null) return null
        val gson = Gson()
        val type = object : TypeToken<List<Int>>() {}.type
        return gson.toJson(qualities, type)
    }

    @TypeConverter
    fun toIntegerList(qualitiesString: String?): List<Int>? {
        if (qualitiesString == null) return null
        val gson = Gson()
        val type = object : TypeToken<List<Int>>() {}.type
        return gson.fromJson(qualitiesString, type)
    }
}
