package com.example.cleancodetest.domain.usecases

import com.example.cleancodetest.domain.models.ProductDomainModel
import com.example.cleancodetest.domain.repository.Repository

class FetchProductByIdUseCase(private val repository: Repository){
    suspend fun execute(productId: Int): ProductDomainModel{
        return repository.fetchProductById(productId)
    }
}