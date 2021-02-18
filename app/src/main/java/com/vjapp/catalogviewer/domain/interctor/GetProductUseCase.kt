package com.vjapp.catalogviewer.domain.interctor

import com.vjapp.catalogviewer.domain.IRepository
import com.vjapp.catalogviewer.domain.model.CatalogEntity
import com.vjapp.catalogviewer.domain.model.ProductEntity

class GetProductUseCase(private val remoteRepository: IRepository) {
    suspend fun execute(): ProductEntity {
        return remoteRepository.getProduct()
    }
}