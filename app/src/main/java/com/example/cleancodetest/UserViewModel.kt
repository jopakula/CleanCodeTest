package com.example.cleancodetest

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cleancodetest.data.storage.models.ProductDataModel
import com.example.cleancodetest.domain.models.ProductDomainModel
import com.example.cleancodetest.domain.models.UserDomainModel
import com.example.cleancodetest.domain.usecases.FetchAllMockProductUseCase
import com.example.cleancodetest.domain.usecases.FetchAllProductUseCase
import com.example.cleancodetest.domain.usecases.FetchProductByIdUseCase
import com.example.cleancodetest.domain.usecases.GetTextUseCase
import com.example.cleancodetest.domain.usecases.SaveTextUseCase
import kotlinx.coroutines.launch

class UserViewModel(
    private val fetchAllProductsUseCase: FetchAllProductUseCase,
    private val fetchProductByIdUseCase: FetchProductByIdUseCase,
    private val fetchAllMockProductUseCase: FetchAllMockProductUseCase,
    private val saveTextUseCase: SaveTextUseCase,
    private val getTextUseCase: GetTextUseCase,
): ViewModel(){
    private val _data = MutableLiveData<ProductDomainModel>()
    val data: LiveData<ProductDomainModel> = _data

    private val _dataList = MutableLiveData<List<ProductDomainModel>>()
    val dataList: LiveData<List<ProductDomainModel>> = _dataList

    private val _mockedProducts = MutableLiveData<List<ProductDomainModel>>()
    val mockedProducts: LiveData<List<ProductDomainModel>> = _mockedProducts

    private val _user = MutableLiveData<UserDomainModel?>()
    val user: LiveData<UserDomainModel?> = _user


    fun fetchDataById(productId: Int){
        viewModelScope.launch {
            try {
                val response = fetchProductByIdUseCase.execute(productId = productId)
                _data.value = response
            } catch (e: Exception){
                Log.wtf("AAA", "$e")
            }
        }
    }

    fun fetchDataList(){
        viewModelScope.launch {
            try {
                val response = fetchAllProductsUseCase.execute()
                _dataList.value = response.products
            } catch (e: Exception){
                Log.wtf("AAA", "$e")
            }
        }
    }

    fun getMockedProduct(){
        viewModelScope.launch {
            try {
                val response = fetchAllMockProductUseCase.execute()
                _mockedProducts.value = response.products
            } catch (e: Exception) {
                Log.wtf("AAA", "$e")
            }
        }
    }

    fun saveUser(user: UserDomainModel) {
        val result = saveTextUseCase.execute(user)
        if (result) {
            _user.value = user
        }
    }

    fun getUser() {
        _user.value = getTextUseCase.execute()
    }
}