package com.hugothomaz.rotafrete.screen.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.hugothomaz.rotafrete.R
import kotlinx.android.synthetic.main.include_toolbar.*

class MainActivity : AppCompatActivity(R.layout.activity_main) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindToolbar()
    }

    private fun bindToolbar() {
        setSupportActionBar(toobar_main)
        supportActionBar?.title = "Meu App"

    }


}