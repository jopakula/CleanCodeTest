package com.example.cleancodetest

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.cleancodetest.data.repository.RepositoryImpl
import com.example.cleancodetest.data.storage.mock.MockStorageImpl
import com.example.cleancodetest.data.storage.network.HttpClient
import com.example.cleancodetest.data.storage.network.NetworkStorageImpl
import com.example.cleancodetest.data.storage.sharedePrefs.SharedPrefsStorageImpl
import com.example.cleancodetest.domain.usecases.FetchAllMockProductUseCase
import com.example.cleancodetest.domain.usecases.FetchAllProductUseCase
import com.example.cleancodetest.domain.usecases.FetchProductByIdUseCase
import com.example.cleancodetest.domain.usecases.GetTextUseCase
import com.example.cleancodetest.domain.usecases.SaveTextUseCase

//class UserViewModelFactory(context: Context): ViewModelProvider.Factory {
//    private val mockStorage by lazy { MockStorageImpl() }
//    private val sharedPrefsStorage by lazy {  SharedPrefsStorageImpl(context = context) }
//    private val networkStorage by lazy { NetworkStorageImpl(networkApi = HttpClient.api) }
//    private val repository by lazy { RepositoryImpl(networkStorage = networkStorage, sharedPrefsStorage = sharedPrefsStorage, mockStorage = mockStorage) }
//    private val fetchAllProductUseCase by lazy { FetchAllProductUseCase(repository = repository) }
//    private val fetchProductByIdUseCase by lazy { FetchProductByIdUseCase(repository = repository) }
//    private val fetchAllMockProductUseCase by lazy { FetchAllMockProductUseCase(repository = repository) }
//    private val saveTextUseCase by lazy { SaveTextUseCase(repository = repository) }
//    private val getTextUseCase by lazy { GetTextUseCase(repository = repository) }
//
//    override fun <T : ViewModel> create(modelClass: Class<T>): T {
//        return UserViewModel(
//            fetchAllProductsUseCase = fetchAllProductUseCase,
//            fetchProductByIdUseCase = fetchProductByIdUseCase,
//            fetchAllMockProductUseCase = fetchAllMockProductUseCase,
//            saveTextUseCase = saveTextUseCase,
//            getTextUseCase = getTextUseCase,
//        ) as T
//    }
//}