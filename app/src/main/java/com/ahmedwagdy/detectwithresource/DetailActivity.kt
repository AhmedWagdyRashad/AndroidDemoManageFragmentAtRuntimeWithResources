package com.ahmedwagdy.detectwithresource

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class DetailActivity : AppCompatActivity(),BlankFragment.FragmentListener {
    private val TAG = "Fragment"
    private var  person:Person = Person("ddd","ddd",0)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        val intent = getIntent()
        // in one single line of code you can get your data form bundle and assign it to your object
        person = intent.getParcelableExtra<Person>("person")

        Log.i(TAG, "DetailActivity_getParcelableExtra: " + person.firstName + ", "
                + person.lastName + ", " + person.age);

    }

    override fun getActivityData():Person {
        return person
    }

    override fun onFragmentFinish(person:Person) {
        Log.i(TAG, "DetailActivity_onFragmentFinish: " + person.firstName + ", "
                + person.lastName + ", " + person.age);
        finish()
    }


}