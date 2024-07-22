package com.example.cleancodetest.domain.usecases

import com.example.cleancodetest.domain.models.UserDomainModel
import com.example.cleancodetest.domain.repository.Repository

class SaveTextUseCase(private val repository: Repository) {
    fun execute(user: UserDomainModel): Boolean {
        val oldText = repository.getText()
        if ((oldText.nameFirst == user.nameFirst) &&(oldText.nameLast == user.nameLast)) {
            return false
        }
        return repository.saveText(user = user)
    }
}
