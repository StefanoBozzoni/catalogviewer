package com.vjapp.catalogviewer.data.repository.datasource

import com.vjapp.catalogviewer.data.exceptions.NetworkCommunicationException
import com.vjapp.catalogviewer.data.remote.AppService
import com.vjapp.catalogviewer.data.remote.model.catalog.CatalogResponse
import com.vjapp.catalogviewer.data.remote.model.product.ProductResponse

class RemoteDataSource(
    private val appService: AppService
) {

    suspend fun httpBinDemo(): String {
        val result = appService.httpBinGetDemo()
        return result.body().toString()
    }

    suspend fun getCatalog(): CatalogResponse {
        val response = appService.getCatalogList()
        if (response.isSuccessful) {
            response.body()?.let { return it }
        }

        throw NetworkCommunicationException()
    }

    suspend fun getProduct(): ProductResponse {
        val response = appService.getProduct()

        if (response.isSuccessful) {
            response.body()?.let { return it }
        }

        throw NetworkCommunicationException()
    }


}