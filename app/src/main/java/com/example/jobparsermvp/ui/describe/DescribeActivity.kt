package com.example.jobparsermvp.ui.describe

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.jobparsermvp.R
import com.example.jobparsermvp.model.DataVacancies

private const val TAG = "DescribeActivity"

class DescribeActivity(private val job: DataVacancies): Fragment(), DescribeContract.ViewI {

    private var presenter = DescribePresenter(this)

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart called")

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.describe_fragment, container, false)

        presenter!!.fillData(view, job)

        return view
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter!!.onDestroy()
    }
}