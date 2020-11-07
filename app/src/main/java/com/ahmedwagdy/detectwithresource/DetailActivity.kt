package com.ahmedwagdy.detectwithresource

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class DetailActivity : AppCompatActivity(),BlankFragment.FragmentListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
    }

    override fun onFragmentFinish(firstName: String, lastName: String, age: Int) {
        Log.i("MainActivity", "detailActivity")
    }
}