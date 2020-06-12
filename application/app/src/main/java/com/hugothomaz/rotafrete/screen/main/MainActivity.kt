package com.hugothomaz.rotafrete.screen.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.databinding.DataBindingUtil
import com.hugothomaz.rotafrete.R
import com.hugothomaz.rotafrete.databinding.ActivityMainBinding
import com.hugothomaz.rotafrete.databinding.FragmentMainBinding
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.include_toolbar.*
import kotlinx.android.synthetic.main.include_toolbar.view.*

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var toolbar : Toolbar?=null

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



    fun getToolbar() : Toolbar? {
        return toolbar
    }


}