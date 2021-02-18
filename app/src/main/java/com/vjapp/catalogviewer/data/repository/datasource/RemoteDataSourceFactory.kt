package com.vjapp.catalogviewer.data.repository.datasource

class RemoteDataSourceFactory(private val remoteDataSource: RemoteDataSource) {
    fun retrieveRemoteDataSource() = remoteDataSource
}