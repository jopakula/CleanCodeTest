package com.example.cleancodetest.data.repository

import com.example.cleancodetest.data.storage.MockStorage
import com.example.cleancodetest.data.storage.NetworkStorage
import com.example.cleancodetest.data.storage.SharedPrefsStorage
import com.example.cleancodetest.data.storage.models.ProductDataModel
import com.example.cleancodetest.data.storage.models.ProductDataResponse
import com.example.cleancodetest.data.storage.models.UserDataModel
import com.example.cleancodetest.domain.models.ProductDomainModel
import com.example.cleancodetest.domain.models.ProductDomainResponse
import com.example.cleancodetest.domain.models.UserDomainModel
import com.example.cleancodetest.domain.repository.Repository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class RepositoryImpl(private val networkStorage: NetworkStorage, private val sharedPrefsStorage: SharedPrefsStorage, private val mockStorage: MockStorage): Repository {
    override suspend fun fetchAllProduct(): ProductDomainResponse {
        return withContext(Dispatchers.IO){
            val productData = networkStorage.fetchNetworkAllProduct()
            mapListNetworkProductToDomain(productData)
        }
    }

    override suspend fun fetchProductById(productId: Int): ProductDomainModel {
        return withContext(Dispatchers.IO){
            val productData = networkStorage.fetchNetworkProductById(productId)
            mapNetworkProductToDomain(productData)
        }
    }

    override suspend fun fetchAllMockProduct(): ProductDomainResponse {
        val productData = mockStorage.fetchAllMockProduct()
        return mapListNetworkProductToDomain(productData)
    }

    override fun saveText(user: UserDomainModel): Boolean {
        val userData = mapToStorage(user)
        return sharedPrefsStorage.save(user = userData)
    }

    override fun getText(): UserDomainModel {
        val userData = sharedPrefsStorage.get()
        return mapToDomain(user = userData)
    }

    private fun mapToStorage(user: UserDomainModel): UserDataModel {
        return UserDataModel(nameFirst = user.nameFirst, nameLast = user.nameLast)
    }

    private fun mapToDomain(user: UserDataModel): UserDomainModel {
        return UserDomainModel(nameFirst = user.nameFirst, nameLast = user.nameLast)
    }

    private fun mapNetworkProductToDomain(product: ProductDataModel): ProductDomainModel {
        return ProductDomainModel(
            id = product.id,
            title = product.title,
            description = product.description,
            category = product.category,
            priсe = product.priсe,
        )
    }

    private fun mapListNetworkProductToDomain(productResponse: ProductDataResponse): ProductDomainResponse  {
        val productDomainList = productResponse.products.map { product ->
            mapNetworkProductToDomain(product)
        }
        return ProductDomainResponse(
            products = productDomainList
        )
    }
}