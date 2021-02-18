package com.vjapp.catalogviewer.domain.interctor

import com.vjapp.catalogviewer.domain.IRepository
import com.vjapp.catalogviewer.domain.model.CatalogEntity

class GetCatalogUseCase(private val remoteRepository: IRepository) {
    suspend fun execute(): CatalogEntity {
        return remoteRepository.getCatalog()
    }
}