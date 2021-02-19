package com.vjapp.catalogviewer.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vjapp.catalogviewer.domain.interctor.GetCatalogUseCase
import com.vjapp.catalogviewer.domain.model.CatalogEntity
import com.vjapp.catalogviewer.domain.model.OperationType
import com.vjapp.catalogviewer.domain.model.SearchTypes
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

class MainViewModel(private val getCatalogUseCase: GetCatalogUseCase) : ViewModel() {
    val getCatalogLiveData = MutableLiveData<Pair<Resource<CatalogEntity>, OperationType>>()

    fun getCatalog(searchType: SearchTypes, operationType: OperationType=OperationType.REPLACE_LIST) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                getCatalogLiveData.postValue(Pair(Resource.loading(), operationType))
                val catalogDeferred =
                    async { getCatalogUseCase.execute(GetCatalogUseCase.Params(searchType)) }
                val catalog = catalogDeferred.await()
                getCatalogLiveData.postValue(Pair(Resource.success(catalog), operationType))
            } catch (t: Throwable) {
                getCatalogLiveData.postValue(Pair(Resource.error("Errore caricamento catalogo"), operationType))
            }
        }
    }


}
