package com.example.jobparsermvp.model

data class DataVacancies(
    // Должность
    val namePos: String,

    // Уровень заработной платы
    val salary:String,

    // Наименование организации
    val titleOrg: String,

    // Площадка
    val jobPlace: String,

    val schedule: String,

    val experience: String,

    val snippetResponsibility: String,
    val snippetRequirement: String
)