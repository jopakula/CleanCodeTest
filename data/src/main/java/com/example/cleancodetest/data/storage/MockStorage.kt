package com.example.cleancodetest.data.storage

import com.example.cleancodetest.data.storage.models.ProductDataModel
import com.example.cleancodetest.data.storage.models.ProductDataResponse

interface MockStorage {

    suspend fun fetchAllMockProduct(): ProductDataResponse

}