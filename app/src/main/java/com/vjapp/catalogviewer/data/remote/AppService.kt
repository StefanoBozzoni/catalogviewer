package com.vjapp.catalogviewer.data.remote

import com.vjapp.catalogviewer.data.remote.model.*
import com.vjapp.catalogviewer.data.remote.model.catalog.CatalogItemResponse
import com.vjapp.catalogviewer.data.remote.model.catalog.CatalogResponse
import com.vjapp.catalogviewer.data.remote.model.product.ProductResponse
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.*

interface AppService {

    //Demo api, just to see if retrofit is working
    @GET("https://httpbin.org/get")
    suspend fun httpBinGetDemo(): Response<Resphttpbin>

    @GET("http://5aaf9b98bcad130014eeaf0b.mockapi.io/ynap/v1/{order}")
    suspend fun getCatalogList(@Path("order") order:String="searchresult"): Response<CatalogResponse>

    @GET("http://5aaf9b98bcad130014eeaf0b.mockapi.io/ynap/v1/item")
    suspend fun getProduct(): Response<ProductResponse>

}