package com.tasneembohra.github.ui

import android.os.Bundle
import com.stayopn.di.application.DaggerActivity
import com.tasneembohra.github.R

class MainActivity : DaggerActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}