package com.vjapp.catalogviewer.data.repository

import android.content.Context
import com.vjapp.catalogviewer.data.repository.datasource.RemoteDataSource
import com.vjapp.catalogviewer.domain.IRepository
import com.vjapp.catalogviewer.domain.mapper.ServiceMapper
import com.vjapp.catalogviewer.domain.model.CatalogEntity
import com.vjapp.catalogviewer.domain.model.ProductEntity

class Repository(
    private val remoteDataSource: RemoteDataSource,
    private val context: Context
) : IRepository {

    override suspend fun httpBinGetDemo(): String {
        return remoteDataSource.httpBinDemo()
    }

    override suspend fun getCatalog(orderType : String): CatalogEntity {
        return ServiceMapper.mapToEntity(remoteDataSource.getCatalog(orderType))
    }

    override suspend fun getProduct(): ProductEntity {
        return ServiceMapper.mapToEntity(remoteDataSource.getProduct())
    }
}