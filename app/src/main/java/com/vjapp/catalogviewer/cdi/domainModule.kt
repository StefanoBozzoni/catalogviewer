package com.vjapp.catalogviewer.cdi

import com.vjapp.catalogviewer.domain.interctor.GetCatalogUseCase
import com.vjapp.catalogviewer.domain.interctor.GetProductUseCase
import org.koin.dsl.module.module

val domainModule = module {

    factory { GetCatalogUseCase(get()) }
    factory { GetProductUseCase(get()) }

}
