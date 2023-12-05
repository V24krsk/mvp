package com.example.jobparsermvp.ui.list

import com.example.jobparsermvp.model.DataVacancies

interface ListContract {
    interface PresenterI {

    }

    interface ViewI {

        fun getItemJob(job: DataVacancies) {}

        interface Callbacks {
            fun onSelectedActivityDescribe(job: DataVacancies)
        }

    }

}