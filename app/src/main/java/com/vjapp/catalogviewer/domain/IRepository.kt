package com.vjapp.catalogviewer.domain

import com.vjapp.catalogviewer.domain.model.CatalogEntity
import com.vjapp.catalogviewer.domain.model.ProductEntity

interface IRepository {
    suspend fun httpBinGetDemo(): String
    suspend fun getCatalog(orderType: String): CatalogEntity
    suspend fun getProduct(): ProductEntity
}