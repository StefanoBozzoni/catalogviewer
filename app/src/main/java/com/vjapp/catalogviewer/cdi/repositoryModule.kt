package com.vjapp.catalogviewer.cdi

import com.vjapp.catalogviewer.data.repository.Repository
import com.vjapp.catalogviewer.data.repository.datasource.RemoteDataSourceFactory
import com.vjapp.catalogviewer.domain.IRepository
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module.module

val repositoryModule = module {
    factory { RemoteDataSourceFactory(get()) }
    single { Repository(get(),androidContext()) as IRepository }
}