package com.example.jobparsermvp.adapter

import com.example.jobparsermvp.model.DataVacancies

interface VacancyOnClickListener {
    fun onClicked(job: DataVacancies)
}