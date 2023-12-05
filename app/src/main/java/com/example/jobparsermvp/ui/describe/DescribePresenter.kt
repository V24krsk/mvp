package com.example.jobparsermvp.ui.describe

import android.view.View
import android.widget.TextView
import com.example.jobparsermvp.R
import com.example.jobparsermvp.model.DataVacancies

private const val TAG = "DescribePresenter"

class DescribePresenter (
    private var describeView: DescribeContract.ViewI?): DescribeContract.PresenterI {

    override fun onDestroy() {
        describeView = null
    }

    fun fillData(view: View, job: DataVacancies) {
        val titleOrgText = view.findViewById<TextView>(R.id.job_d_title)
        val namePosText = view.findViewById<TextView>(R.id.job_d_namepos)
        val salaryText = view.findViewById<TextView>(R.id.job_d_salary)
        val placeText = view.findViewById<TextView>(R.id.job_d_place)
        val scheduleText = view.findViewById<TextView>(R.id.job_d_schedule)
        val experienceText = view.findViewById<TextView>(R.id.job_d_experience)
        val describeText = view.findViewById<TextView>(R.id.job_d_describ)

        titleOrgText.text = job.titleOrg
        namePosText.text = job.namePos
        salaryText.text = job.salary
        placeText.text = job.jobPlace
        scheduleText.text = job.schedule
        experienceText.text = job.experience
        describeText.text = job.snippetRequirement + job.snippetResponsibility
    }

}