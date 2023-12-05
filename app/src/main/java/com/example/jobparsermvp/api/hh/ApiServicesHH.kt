package com.example.jobparsermvp.api.hh

import com.example.jobparsermvp.model.hh.Vacancies
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiServicesHH {

    @GET("/vacancies")
    fun getVacanciesArea( @Query("area") idArea: Int): Call<Vacancies>

    @GET("/vacancies")
    fun getVacanciesAreaPos( @Query("area") idArea: Int,
                                     @Query("search_field") searchField: String,
                                     @Query("text") namePos: String): Call<Vacancies>


    @GET("/vacancies")
    fun getVacanciesAreaPosPage( @Query("area") idArea: Int,
                                         @Query("search_field") searchField: String,
                                         @Query("text") namePos: String,
                                         @Query("page") idPage: String): Call<Vacancies>
}