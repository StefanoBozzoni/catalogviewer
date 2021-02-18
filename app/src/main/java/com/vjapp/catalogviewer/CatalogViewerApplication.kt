package com.vjapp.catalogviewer

import android.app.Application
import com.vjapp.catalogviewer.cdi.domainModule
import com.vjapp.catalogviewer.cdi.repositoryModule
import com.vjapp.catalogviewer.cdi.viewModelModule
import localModule
import org.koin.android.ext.android.startKoin
import remoteModule

class CatalogViewerApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin(this,listOf(viewModelModule, repositoryModule,
                                           localModule, remoteModule, domainModule), logger= KoinLogger())
    }
}
