package com.example.cleancodetest.data.storage

import com.example.cleancodetest.data.storage.models.UserDataModel

interface SharedPrefsStorage {
    fun save(user: UserDataModel): Boolean

    fun get(): UserDataModel
}