package com.example.jobparsermvp.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.jobparsermvp.R
import com.example.jobparsermvp.model.DataVacancies
import com.example.jobparsermvp.ui.list.ListContract

private const val TAG = "VacancyAdapter"
class VacancyAdapter(private val jobs: MutableList<DataVacancies>,
                     private val onClickListener: VacancyOnClickListener): RecyclerView.Adapter<VacancyAdapter.JobHolder>() {

    class JobHolder(view: View) : RecyclerView.ViewHolder(view) {
        private lateinit var job: DataVacancies


        private val namePosTextView: TextView = itemView.findViewById(R.id.namePos)
        private val salaryLevelTextView: TextView = itemView.findViewById(R.id.salaryLevel)
        private val titleOrgTextView: TextView = itemView.findViewById(R.id.titleOrg)
        private val jobPlaceTextView: TextView = itemView.findViewById(R.id.jobPlace)

        fun bind(job: DataVacancies) {
            this.job = job
            namePosTextView.text = this.job.namePos
            salaryLevelTextView.text = this.job.salary
            titleOrgTextView.text = this.job.titleOrg
            jobPlaceTextView.text = this.job.jobPlace
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VacancyAdapter.JobHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item_fragment, parent, false)

        return JobHolder(view)
    }

    override fun getItemCount() = jobs.size

    override fun onBindViewHolder(holder: VacancyAdapter.JobHolder, position: Int) {
        val job = jobs[position]
        holder.bind(job)
        holder.itemView.setOnClickListener {
            onClickListener.onClicked(job)
        }

    }

}