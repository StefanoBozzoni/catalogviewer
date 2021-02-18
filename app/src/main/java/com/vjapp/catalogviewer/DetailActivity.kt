package com.vjapp.catalogviewer

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
    }

    override fun onSupportNavigateUp(): Boolean {
        return true
    }

    companion object {
        fun newInstance(context: Context):Intent {
            return Intent(context, DetailActivity::class.java).addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP)
        }
    }

}
