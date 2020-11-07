package com.ahmedwagdy.detectwithresource

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*
import kotlinx.android.synthetic.main.fragment_main.*

class MainActivity : AppCompatActivity() {
    private var mTablet:Boolean? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mTablet = (detail_fragment_container != null)
        textOut.text = "Fragment side-by-side? $mTablet"

        fab.setOnClickListener{
            if (mTablet as Boolean){
                supportFragmentManager.beginTransaction()
                    .add(R.id.detail_fragment_container,BlankFragment())
                    .commit()
            }else{
                val intent = Intent(this, DetailActivity::class.java)
                startActivity(intent)
            }
        }

    }
}