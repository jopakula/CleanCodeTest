package com.example.cleancodetest.domain.usecases

import com.example.cleancodetest.domain.models.ProductDomainModel
import com.example.cleancodetest.domain.models.UserDomainModel
import com.example.cleancodetest.domain.repository.Repository

class GetTextUseCase(private val repository: Repository) {
    fun execute(): UserDomainModel {
        return repository.getText()
    }
}
