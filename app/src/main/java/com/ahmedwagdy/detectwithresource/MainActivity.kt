package com.ahmedwagdy.detectwithresource

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.content_main.*
import kotlinx.android.synthetic.main.fragment_blank.*
import kotlinx.android.synthetic.main.fragment_main.*

class MainActivity : AppCompatActivity(), BlankFragment.FragmentListener {
    private var mTablet:Boolean? = null
    private val TAG = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mTablet = (detail_fragment_container != null)
        textOut.text = "Fragment side-by-side? $mTablet"

        fab.apply {
            setOnClickListener {
                if (mTablet as Boolean) {
                    supportFragmentManager.beginTransaction()
                        .add(R.id.detail_fragment_container, BlankFragment())
                        .commit()
                } else {
                    val intent = Intent(context, DetailActivity::class.java)
                    startActivity(intent)
                }
            }

        }

    }

    override fun onFragmentFinish(firstName: String, lastName: String, age: Int) {
        Log.i(TAG, "onFragmentFinish: " + firstName + ", "
                + lastName + ", " + age);
        val fragment = supportFragmentManager.findFragmentById(R.id.detail_fragment_container)
        fragment?.let { supportFragmentManager.beginTransaction().remove(it).commit() }
    }
}