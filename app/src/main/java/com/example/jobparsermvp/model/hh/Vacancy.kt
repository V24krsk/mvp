package com.example.jobparsermvp.model.hh


data class Vacancy(
    // namePos
    val name: String,
    // salaryLevel
    val salary: Map<String, Any>?,
    // titleOrg
    val employer: Map<String, Any>,
    // График
    val schedule: Map<String, Any>,

    val experience: Map<String, Any>,

    val snippet: Map<String, Any>
)

