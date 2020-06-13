package com.hugothomaz.rotafrete.screen.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.databinding.DataBindingUtil
import com.hugothomaz.rotafrete.R
import com.hugothomaz.rotafrete.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var toolbar: Toolbar? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        bindToolbar()
    }

    private fun bindToolbar() {
        toolbar = binding.includeToolbarMain.toobarMain
        supportActionBar?.apply {
            setDisplayHomeAsUpEnabled(false)
            setHomeButtonEnabled(false)
        }
        setSupportActionBar(toolbar)
    }

    fun getToolbar(): Toolbar? {
        return toolbar
    }

}