package com.example.cleancodetest.domain.usecases

import com.example.cleancodetest.domain.models.ProductDomainModel
import com.example.cleancodetest.domain.models.ProductDomainResponse
import com.example.cleancodetest.domain.repository.Repository

class FetchAllProductUseCase(private val repository: Repository){
    suspend fun execute(): ProductDomainResponse{
        return repository.fetchAllProduct()
    }
}