package com.gozde.myapplication.network.interceptor

import com.gozde.myapplication.base.AppConstants
import okhttp3.HttpUrl
import okhttp3.Interceptor
import okhttp3.Response

class HeaderInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val url: HttpUrl = chain.request().url.newBuilder()
            .build()
        return chain.proceed(
            chain.request().newBuilder().addHeader("authorization", AppConstants.collectapi_api_key)
                .addHeader("content-type", "application/json").url(url).build()
        )
    }

}