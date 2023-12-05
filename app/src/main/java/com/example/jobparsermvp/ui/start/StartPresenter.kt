package com.example.jobparsermvp.ui.start

class StartPresenter (
    private var startView: StartContract.ViewI?): StartContract.PresenterI {

    override fun onDestroy() {
        startView = null
    }

    override fun onButtonGetClick() {
        if (startView != null) startView!!.getListActivity()
    }

}