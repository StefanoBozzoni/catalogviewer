package com.vjapp.catalogviewer

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.vjapp.catalogviewer.adapters.CatalogAdapter
import com.vjapp.catalogviewer.domain.model.CatalogEntity
import com.vjapp.catalogviewer.domain.model.ProductEntity
import com.vjapp.catalogviewer.presentation.DetailViewModel
import com.vjapp.catalogviewer.presentation.Resource
import com.vjapp.catalogviewer.presentation.ResourceState
import kotlinx.android.synthetic.main.activity_tests_list.*
import kotlinx.android.synthetic.main.fragment_detail.*
import org.koin.android.viewmodel.ext.android.sharedViewModel

class DetailFragment : Fragment() {

    val detailViewModel: DetailViewModel by sharedViewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_detail, container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        detailViewModel.getProduct()
        initializeHandlers()
    }

    fun initView() {

    }

    private fun initializeHandlers() {
        detailViewModel.getProductLiveData.observe(viewLifecycleOwner, Observer { response ->
            response?.let { handleGetProductComplete(response) }
        })
    }

    private fun handleGetProductComplete(response: Resource<ProductEntity>) {
        when (response.status) {
            //ResourceState.LOADING -> vf_catalog.displayedChild = 0
            ResourceState.SUCCESS -> {
                //vf_catalog.displayedChild = 1
                setViewForSuccess(response.data)
            }
            //ResourceState.ERROR -> vf_catalog.displayedChild = 2
        }
    }

    private fun setViewForSuccess(product: ProductEntity?) {
        //Fill the ricyclerview with catalog data
        product?.let  {
            tvBrand.text  = product.brandName
            tvCategory.text = product.category
            tvPrice.text = product.price
        }
    }

}