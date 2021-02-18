package com.vjapp.catalogviewer.data.setup

import okhttp3.Interceptor
import okhttp3.logging.HttpLoggingInterceptor

object NetworkModule {

    fun createHttpLoggingInterceptor(): HttpLoggingInterceptor {
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        return loggingInterceptor
    }

    fun createHeadersInterceptor() = Interceptor {
        val request = it.request().newBuilder()
            .addHeader("Content-Type", "application/x-www-form-urlencoded")
            .build()
        it.proceed(request)
    }
}