package com.example.jobparsermvp.model.hh

data class Vacancies(
    val items: List<Vacancy>,
    val pages: String,
    val page: String,
    val found: Int
)
