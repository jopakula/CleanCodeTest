package com.example.cleancodetest.data.storage.sharedePrefs

import android.content.Context
import com.example.cleancodetest.data.storage.SharedPrefsStorage
import com.example.cleancodetest.data.storage.models.UserDataModel

private const val SHARED_PREFS_NAME = "shared_prefs_name"
private const val KEY_TEXT_NAME_FIRST = "key_first_name"
private const val KEY_TEXT_NAME_LAST = "key_last_name"

class SharedPrefsStorageImpl(context: Context): SharedPrefsStorage {
    private val sharedPreferences = context.getSharedPreferences(SHARED_PREFS_NAME, Context.MODE_PRIVATE)

    override fun save(user: UserDataModel): Boolean {
        sharedPreferences.edit().putString(KEY_TEXT_NAME_FIRST, user.nameFirst).apply()
        sharedPreferences.edit().putString(KEY_TEXT_NAME_LAST, user.nameLast).apply()
        return true
    }


    override fun get(): UserDataModel {
        val nameFirst = sharedPreferences.getString(KEY_TEXT_NAME_FIRST, "") ?: ""
        val nameLast = sharedPreferences.getString(KEY_TEXT_NAME_LAST, "") ?: ""
        return UserDataModel(nameFirst = nameFirst, nameLast = nameLast)
    }
}