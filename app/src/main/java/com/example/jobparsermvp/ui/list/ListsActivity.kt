package com.example.jobparsermvp.ui.list

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.jobparsermvp.R
import com.example.jobparsermvp.model.DataVacancies


private const val TAG = "ListActivity"

class ListsActivity: Fragment(), ListContract.ViewI {

    private lateinit var jobRecyclerView: RecyclerView
    private var presenter = ListPresenter(this)
    private var callbacksDescrib: ListContract.ViewI.Callbacks? = null


    override fun onAttach(context: Context) {
        super.onAttach(context)
        callbacksDescrib = context as ListContract.ViewI.Callbacks?
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "Create ListActivity")
    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.list_fragment, container, false)

        jobRecyclerView = view.findViewById(R.id.jobs_recycler_view) as RecyclerView
        jobRecyclerView.layoutManager = LinearLayoutManager(context)

        Log.d(TAG, "call getJobsList")
        presenter.getJobsList(jobRecyclerView)

        return view
    }

    override fun onDetach() {
        super.onDetach()
        callbacksDescrib = null
    }

    override fun getItemJob(job: DataVacancies) {
        callbacksDescrib?.onSelectedActivityDescribe(job)
    }

}


