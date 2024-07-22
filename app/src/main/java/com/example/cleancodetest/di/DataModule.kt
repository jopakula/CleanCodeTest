package com.example.cleancodetest.di

import com.example.cleancodetest.data.repository.RepositoryImpl
import com.example.cleancodetest.data.storage.MockStorage
import com.example.cleancodetest.data.storage.NetworkStorage
import com.example.cleancodetest.data.storage.SharedPrefsStorage
import com.example.cleancodetest.data.storage.mock.MockStorageImpl
import com.example.cleancodetest.data.storage.network.HttpClient
import com.example.cleancodetest.data.storage.network.NetworkApi
import com.example.cleancodetest.data.storage.network.NetworkStorageImpl
import com.example.cleancodetest.data.storage.sharedePrefs.SharedPrefsStorageImpl
import com.example.cleancodetest.domain.repository.Repository
import org.koin.dsl.module

val dataModule = module {

    single<NetworkApi> { HttpClient.api }
    single<NetworkStorage> { NetworkStorageImpl(networkApi = get()) }
    single<SharedPrefsStorage> { SharedPrefsStorageImpl(context = get()) }
    single<MockStorage> { MockStorageImpl() }
    single<Repository> { RepositoryImpl(networkStorage = get(), sharedPrefsStorage = get(), mockStorage = get()) }
}