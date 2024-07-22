package com.example.cleancodetest.di

import com.example.cleancodetest.domain.usecases.FetchAllMockProductUseCase
import com.example.cleancodetest.domain.usecases.FetchAllProductUseCase
import com.example.cleancodetest.domain.usecases.FetchProductByIdUseCase
import com.example.cleancodetest.domain.usecases.GetTextUseCase
import com.example.cleancodetest.domain.usecases.SaveTextUseCase
import org.koin.dsl.module

val domainModule = module {

    factory<FetchAllProductUseCase> {
        FetchAllProductUseCase(repository = get())
    }

    factory<FetchProductByIdUseCase> {
        FetchProductByIdUseCase(repository = get())
    }

    factory<FetchAllMockProductUseCase> {
        FetchAllMockProductUseCase(repository = get())
    }

    factory<SaveTextUseCase> {
        SaveTextUseCase(repository = get())
    }

    factory<GetTextUseCase> {
        GetTextUseCase(repository = get())
    }
}