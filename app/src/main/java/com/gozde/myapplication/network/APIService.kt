package com.gozde.myapplication.network

import com.gozde.myapplication.model.BaseResponse
import retrofit2.Response
import retrofit2.http.GET

interface APIService {
    @GET("/corona/countriesData")
    suspend fun getCountriesData(): Response<BaseResponse>
}