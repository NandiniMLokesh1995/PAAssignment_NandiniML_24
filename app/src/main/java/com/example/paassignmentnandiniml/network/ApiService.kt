package com.example.paassignmentnandiniml.network

import com.example.paassignmentnandiniml.entities.CoverageItemEntity
import io.ktor.client.request.parameter
import io.ktor.client.request.*

object ApiService {
    private val client = ApiClient.client

    suspend fun fetchItems(limit: Int): List<CoverageItemEntity> {
        return client.get {
            this.url("https://acharyaprashant.org/api/v2/content/misc/media-coverages")
            parameter("limit", limit)
        }
    }
}