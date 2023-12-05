package com.example.jobparsermvp.ui.start

interface StartContract {

    interface PresenterI {
        fun onButtonGetClick()
        fun onDestroy()
    }

    interface ViewI {
        interface Callbacks {
            fun onSelectedActivityList()
        }

        fun getListActivity()

    }

}