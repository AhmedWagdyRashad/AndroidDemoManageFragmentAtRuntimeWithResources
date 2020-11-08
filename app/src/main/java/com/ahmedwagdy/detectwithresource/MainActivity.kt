package com.ahmedwagdy.detectwithresource

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.content_main.*
import kotlinx.android.synthetic.main.fragment_main.*

class MainActivity : AppCompatActivity(), BlankFragment.FragmentListener {
    private var mTablet:Boolean? = null
    private val TAG = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mTablet = (detail_fragment_container != null)
        textOut.text = "Fragment side-by-side? $mTablet"

        val person = Person("first name", "last name", 35)
        val bundle = Bundle()
        bundle.putParcelable("person",person)
        fab.apply {
            setOnClickListener {
                if (mTablet as Boolean) {
                    val blankFragment = BlankFragment.newInstance(person)
                    supportFragmentManager.beginTransaction()
                        .add(R.id.detail_fragment_container, blankFragment)
                        .commit()
                } else {
                    val intent = Intent(context, DetailActivity::class.java)
                    startActivity(intent)
                }
            }

        }

    }

    override fun onFragmentFinish(person: Person) {
        Log.i(TAG, "onFragmentFinish: " + person.firstName + ", "
                + person.lastName + ", " + person.age);
        val fragment = supportFragmentManager.findFragmentById(R.id.detail_fragment_container)
        fragment?.let { supportFragmentManager.beginTransaction().remove(it).commit() }
    }
}