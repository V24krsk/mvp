package com.example.jobparsermvp.api.hh

import com.example.jobparsermvp.api.ApiClient
import com.example.jobparsermvp.common.Constants

object CommonHH {
    private val BASE_URL = Constants().BASE_API_URL_HH
    val apiServices: ApiServicesHH
        get() = ApiClient.getClient(BASE_URL).create(ApiServicesHH::class.java)
}