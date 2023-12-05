package com.example.jobparsermvp.ui.start

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.CheckBox
import androidx.fragment.app.Fragment
import com.example.jobparsermvp.R

class StartActivity: Fragment(), StartContract.ViewI {
    private val TAG = "StartActivity"

    private var presenter = StartPresenter(this)
    private var callbacksList: StartContract.ViewI.Callbacks? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        callbacksList = context as StartContract.ViewI.Callbacks?
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart called")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.start_fragment, container, false)


        val b = view.findViewById<Button>(R.id.button_get);
        b.isEnabled = false;
        b.setOnClickListener {
            presenter!!.onButtonGetClick()
        }

        val c = view.findViewById<CheckBox>(R.id.checkBox_hh);
        c.setOnCheckedChangeListener { compoundButton, isChecked ->
            b.isEnabled = isChecked
        }

        return view
    }

    override fun onDetach() {
        super.onDetach()
        callbacksList = null
    }

    override fun getListActivity() {
        callbacksList?.onSelectedActivityList()
    }


}