package com.example.cleancodetest.domain.repository

import com.example.cleancodetest.domain.models.ProductDomainModel
import com.example.cleancodetest.domain.models.ProductDomainResponse
import com.example.cleancodetest.domain.models.UserDomainModel

interface Repository {

    suspend fun fetchAllProduct(): ProductDomainResponse

    suspend fun fetchProductById(productId: Int): ProductDomainModel

    suspend fun fetchAllMockProduct(): ProductDomainResponse

    fun saveText(user: UserDomainModel): Boolean

    fun getText(): UserDomainModel
}