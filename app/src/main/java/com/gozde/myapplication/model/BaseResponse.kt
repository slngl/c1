package com.gozde.myapplication.model



data class BaseResponse(
    val result: List<CountryResult>? = null,
    val success: Boolean? = null
)