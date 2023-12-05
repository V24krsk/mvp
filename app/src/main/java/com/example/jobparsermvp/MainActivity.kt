package com.example.jobparsermvp

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.jobparsermvp.model.DataVacancies
import com.example.jobparsermvp.ui.describe.DescribeActivity
import com.example.jobparsermvp.ui.list.ListContract
import com.example.jobparsermvp.ui.list.ListsActivity
import com.example.jobparsermvp.ui.start.StartActivity
import com.example.jobparsermvp.ui.start.StartContract

private const val TAG = "MainActivity"

class MainActivity : AppCompatActivity(),
                     StartContract.ViewI.Callbacks,
                     ListContract.ViewI.Callbacks {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)

        val currentFragment = supportFragmentManager.findFragmentById(R.id.fragment_container)

        if (currentFragment == null) {
            val fragment = StartActivity()
            supportFragmentManager
                .beginTransaction()
                .add(R.id.fragment_container, fragment)
                .commit()
        }

    }

    override fun onSelectedActivityList() {
        Log.d(TAG, "MainActivity.onSelectedActivityList")
        val fragment = ListsActivity()
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .addToBackStack(null)
            .commit()
    }

    override fun onSelectedActivityDescribe(job: DataVacancies) {
        Log.d(TAG, "MainActivity.onSelectedActivityDescribe")
        val fragment = DescribeActivity(job)
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .addToBackStack(null)
            .commit()
    }

}
