package com.ahmedwagdy.detectwithresource

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_blank.view.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [BlankFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class BlankFragment : Fragment() {
    val TAG = "MainActivity"
    lateinit var mListener:FragmentListener
    lateinit var textFirstName:EditText
    lateinit var textLastName:EditText
    lateinit var textAge:EditText

    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.fragment_blank, container, false)

        textFirstName = rootView.text_first_name
        textLastName = rootView.text_last_name
        textAge = rootView.text_age
        val person: Person? = arguments?.getParcelable("PERSON_KEY")
        textFirstName.setText(person?.firstName)
        textLastName.setText(person?.lastName)
        textAge.setText(person?.age.toString())

        val doneButton = rootView.done_button
        doneButton.setOnClickListener {
                done()
        }
        return rootView
    }

    private fun done() {
        if (mListener == null){
            throw AssertionError()
        }
        val firstName = textFirstName.text.toString()
        val lastName = textLastName.text.toString()
        val age = Integer.valueOf(textAge.text.toString())
        val person = Person(firstName, lastName, age)
       mListener.onFragmentFinish(person)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment BlankFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            BlankFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }

        fun newInstance(person:Person) : BlankFragment{
            val bundle = Bundle()
            bundle.putParcelable("PERSON_KEY",person)
            val fragment = BlankFragment()
            fragment.arguments = bundle
            return fragment
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.i(TAG,"onAttach1")
        if(context !is FragmentListener) throw AssertionError()
        mListener = context
        Log.i(TAG,"onAttach2")
    }

    interface FragmentListener{
        fun onFragmentFinish(person:Person)
    }
}