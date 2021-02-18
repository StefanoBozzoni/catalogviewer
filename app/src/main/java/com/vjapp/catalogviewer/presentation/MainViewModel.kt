package com.vjapp.catalogviewer.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vjapp.catalogviewer.domain.interctor.GetCatalogUseCase
import com.vjapp.catalogviewer.domain.model.CatalogEntity
import com.vjapp.catalogviewer.domain.model.CatalogItemEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainViewModel(private val getCatalogUseCase: GetCatalogUseCase) : ViewModel() {
    val getCatalogLiveData = MutableLiveData<Resource<CatalogEntity>>()

    fun getCatalog() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                getCatalogLiveData.postValue(Resource.loading())
                val catalogDeferred = async { getCatalogUseCase.execute() }
                val catalog = catalogDeferred.await()
                getCatalogLiveData.postValue(Resource.success(catalog))
            } catch (t: Throwable) {
                getCatalogLiveData.postValue(Resource.error("Errore caricamento catalogo"))
            }
        }
    }

}
