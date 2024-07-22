package com.example.cleancodetest.data.storage.mock

import com.example.cleancodetest.data.storage.models.ProductDataModel
import com.example.cleancodetest.domain.models.ProductDomainModel

object MockData {
    val sampleProducts = listOf(
        ProductDataModel(1, "Product 1", "Description 1", "Category 1", 10.0F),
        ProductDataModel(2, "Product 2", "Description 2", "Category 2", 20.0F),
        ProductDataModel(3, "Product 3", "Description 3", "Category 3", 30.0F),
        ProductDataModel(4, "Product 4", "Description 4", "Category 4", 40.0F),
    )
}