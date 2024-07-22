package com.example.cleancodetest.data.storage.network

import com.example.cleancodetest.data.storage.models.ProductDataModel
import com.example.cleancodetest.data.storage.models.ProductDataResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface NetworkApi {
    @GET("products")
    suspend fun fetchProducts(): ProductDataResponse

    @GET("product/{id}")
    suspend fun fetchProductById(@Path("id") productId: Int,): ProductDataModel
}