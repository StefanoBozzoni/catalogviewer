package com.vjapp.catalogviewer

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.vjapp.catalogviewer.domain.model.SearchTypes
import com.vjapp.catalogviewer.presentation.MainViewModel
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.viewmodel.ext.android.viewModel

class CatalogSearchActivity : AppCompatActivity(),
    BottomNavigationView.OnNavigationItemSelectedListener {

    val mainViewModel: MainViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        nav_view.setOnNavigationItemSelectedListener(this)

    }


    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.navigation_highest -> mainViewModel.getCatalog(SearchTypes.HIGHEST)
            R.id.navigation_lowest -> mainViewModel.getCatalog(SearchTypes.LOWEST)
            R.id.navigation_latest -> mainViewModel.getCatalog(SearchTypes.LATEST)
        }

        return true
    }


    override fun onSupportNavigateUp(): Boolean {
        return true
    }

}
