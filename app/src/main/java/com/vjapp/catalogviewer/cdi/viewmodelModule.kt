package com.vjapp.catalogviewer.cdi

import com.vjapp.catalogviewer.presentation.*
import org.koin.android.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module

val viewModelModule = module {
    viewModel { MainViewModel(get()) }
    viewModel { DetailViewModel(get()) }
}
