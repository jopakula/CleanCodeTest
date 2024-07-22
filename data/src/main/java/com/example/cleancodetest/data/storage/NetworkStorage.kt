package com.example.cleancodetest.data.storage

import com.example.cleancodetest.data.storage.models.ProductDataModel
import com.example.cleancodetest.data.storage.models.ProductDataResponse

interface NetworkStorage {

    suspend fun fetchNetworkAllProduct(): ProductDataResponse

    suspend fun fetchNetworkProductById(productId: Int): ProductDataModel
}