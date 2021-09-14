package com.gozde.myapplication.repository

import com.gozde.myapplication.base.BaseRepository
import com.gozde.myapplication.model.BaseResponse
import com.gozde.myapplication.model.CountryResult
import com.gozde.myapplication.model.DataHolder
import com.gozde.myapplication.network.APIService
import javax.inject.Inject

class CoronaRepository @Inject constructor(val api: APIService) : BaseRepository() {
    suspend fun getCountriesData(): DataHolder<BaseResponse>{
        return safeApiCall({api.getCountriesData()}, "getCountriesData error")
    }
}