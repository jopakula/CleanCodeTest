package com.example.cleancodetest.di

import com.example.cleancodetest.UserViewModel
import org.koin.androidx.compose.get
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {

    viewModel<UserViewModel> {
        UserViewModel(
            fetchAllProductsUseCase = get(),
            fetchProductByIdUseCase = get(),
            fetchAllMockProductUseCase = get(),
            saveTextUseCase = get(),
            getTextUseCase = get(),
        )
    }
}