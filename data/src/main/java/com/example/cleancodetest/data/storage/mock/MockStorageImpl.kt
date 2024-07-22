package com.example.cleancodetest.data.storage.mock

import com.example.cleancodetest.data.storage.MockStorage
import com.example.cleancodetest.data.storage.models.ProductDataModel
import com.example.cleancodetest.data.storage.models.ProductDataResponse

class MockStorageImpl: MockStorage {
    override suspend fun fetchAllMockProduct(): ProductDataResponse {
        return ProductDataResponse(MockData.sampleProducts)
    }
}