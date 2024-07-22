package com.example.cleancodetest.data.map

import com.example.cleancodetest.data.storage.models.ProductDataModel
import com.example.cleancodetest.domain.models.ProductDomainModel

internal fun mapNetworkProductToDomain(product: ProductDataModel): ProductDomainModel {
    return ProductDomainModel(
        id = product.id,
        title = product.title,
        description = product.description,
        category = product.category,
        priсe = product.priсe,
    )
}