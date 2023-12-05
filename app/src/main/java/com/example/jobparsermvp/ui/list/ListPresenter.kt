package com.example.jobparsermvp.ui.list

import android.util.Log
import androidx.recyclerview.widget.RecyclerView
import com.example.jobparsermvp.adapter.VacancyAdapter
import com.example.jobparsermvp.adapter.VacancyOnClickListener
import com.example.jobparsermvp.api.hh.ApiServicesHH
import com.example.jobparsermvp.api.hh.CommonHH
import com.example.jobparsermvp.common.Constants
import com.example.jobparsermvp.model.DataVacancies
import com.example.jobparsermvp.model.hh.Vacancies
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

private const val TAG = "ListPresenter"

class ListPresenter(private var listView: ListContract.ViewI?): ListContract.PresenterI {

    private var hhService: ApiServicesHH = CommonHH.apiServices
    private lateinit var adapter: VacancyAdapter

    private val constVal = Constants()
    var jobsAll = mutableListOf<DataVacancies>()


    fun getJobsList(jobRecyclerView: RecyclerView) {
        getJobsListHH(jobRecyclerView)
        //getJobsListYA(jobRecyclerView)
    }


    private fun getJobsListHH(jobRecyclerView: RecyclerView) {
        var salaryFrom: Double? = null
        var salaryTo: Double? = null
        var msgSalary = "Зарплата"

        hhService.getVacanciesAreaPos(
            constVal.AREA_HH,
            constVal.SEARCH_FIELD_NAME,
            constVal.POS_DEVELOPER).enqueue(object: Callback<Vacancies> {
            override fun onFailure(call: Call<Vacancies>, t: Throwable) {
                Log.e(TAG, "*********** No data *************")
            }

            override fun onResponse(call: Call<Vacancies>,
                                    response: Response<Vacancies>
            ) {
                val resB = response.body() as Vacancies

                for (i in resB.items) {
                    if (i.salary != null) {
                        salaryFrom = if (i.salary["from"] != null) i.salary["from"] as Double?
                        else 0.0
                        if (salaryFrom!! > 0) msgSalary += " от " + salaryFrom!!.toInt().toString()

                        salaryTo = if (i.salary["to"] != null) i.salary["to"] as Double?
                        else 0.0
                        if (salaryTo!! > 0) msgSalary += " до " + salaryTo!!.toInt().toString()

                        msgSalary += " (" + i.salary["currency"] + ")"

                    } else msgSalary +=  " не указана."

                    jobsAll.add(DataVacancies(i.name,
                        msgSalary,
                        i.employer["name"].toString(),
                        constVal.PLACE_HH,
                        i.schedule["name"].toString(),
                        i.experience["name"].toString(),
                        i.snippet["responsibility"].toString(),
                        i.snippet["requirement"].toString()))

                    msgSalary = "Зарплата"
                }

                adapter = VacancyAdapter(jobsAll, object : VacancyOnClickListener{
                    override fun onClicked(job: DataVacancies) {
                        Log.d(TAG, "click ItemView")
                        listView!!.getItemJob(job)
                    }

                })
                adapter.notifyDataSetChanged()
                jobRecyclerView.adapter = adapter

            }
        })
    }

//    private fun getJobsListYA(jobRecyclerView: RecyclerView) {
//
//    }
}