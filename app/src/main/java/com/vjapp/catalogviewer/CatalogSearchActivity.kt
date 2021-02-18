package com.vjapp.catalogviewer

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.vjapp.catalogviewer.adapters.CatalogAdapter
import com.vjapp.catalogviewer.domain.model.CatalogEntity
import com.vjapp.catalogviewer.domain.model.CatalogItemEntity
import com.vjapp.catalogviewer.presentation.MainViewModel
import com.vjapp.catalogviewer.presentation.Resource
import com.vjapp.catalogviewer.presentation.ResourceState
import kotlinx.android.synthetic.main.activity_tests_list.*
import org.koin.android.viewmodel.ext.android.viewModel

class CatalogSearchActivity : AppCompatActivity(),
    BottomNavigationView.OnNavigationItemSelectedListener {

    val mainViewModel: MainViewModel by viewModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }


    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        return true
    }


    override fun onSupportNavigateUp(): Boolean {
        return true
    }


}
