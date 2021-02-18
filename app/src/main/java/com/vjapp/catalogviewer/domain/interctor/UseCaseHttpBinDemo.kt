package com.vjapp.catalogviewer.domain.interctor

import com.vjapp.catalogviewer.domain.IRepository

class UseCaseHttpBinDemo(private val remoteRepository: IRepository) {
    suspend fun execute(): String {
        return remoteRepository.httpBinGetDemo()
    }
}