package com.example.paassignmentnandiniml.entities

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities

class Util {

    fun getImageQuality(context: Context): String {
        val connectivityManager =
            context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetwork = connectivityManager.activeNetwork
        val networkCapabilities = connectivityManager.getNetworkCapabilities(activeNetwork)

        return when {
            networkCapabilities?.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) == true -> "high"
            networkCapabilities?.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) == true -> {
                val linkDownstreamBandwidthKbps = networkCapabilities.linkDownstreamBandwidthKbps
                when {
                    linkDownstreamBandwidthKbps > 5000 -> "high" // Greater than 5 Mbps
                    linkDownstreamBandwidthKbps > 1000 -> "medium" // 1 Mbps to 5 Mbps
                    else -> "low" // Less than 1 Mbps
                }
            }

            else -> "low" // No known network or slow network
        }
    }

}