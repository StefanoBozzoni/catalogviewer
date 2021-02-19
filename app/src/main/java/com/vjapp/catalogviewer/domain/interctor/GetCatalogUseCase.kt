package com.vjapp.catalogviewer.domain.interctor

import com.vjapp.catalogviewer.domain.IRepository
import com.vjapp.catalogviewer.domain.mapper.ServiceMapper
import com.vjapp.catalogviewer.domain.model.CatalogEntity
import com.vjapp.catalogviewer.domain.model.SearchTypes

class GetCatalogUseCase(private val remoteRepository: IRepository) {
    suspend fun execute(params:Params): CatalogEntity {
        return remoteRepository.getCatalog(ServiceMapper.mapOrderType(params.orderType))
    }

    class Params(val orderType: SearchTypes)
}