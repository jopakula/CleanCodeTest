package com.example.cleancodetest.data.storage.network

import com.example.cleancodetest.data.storage.NetworkStorage
import com.example.cleancodetest.data.storage.models.ProductDataModel
import com.example.cleancodetest.data.storage.models.ProductDataResponse

class NetworkStorageImpl(private val networkApi: NetworkApi): NetworkStorage {
    override suspend fun fetchNetworkAllProduct(): ProductDataResponse {
        return networkApi.fetchProducts()
    }

    override suspend fun fetchNetworkProductById(productId: Int): ProductDataModel {
        return networkApi.fetchProductById(productId)
    }
}