package com.kryptkode.componentarchitecture.remote.api

import okhttp3.Interceptor
import okhttp3.Response

class HttpsEnforcerInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        val requestBuilder = request.newBuilder()
        if(request.isHttps.not()){
            val newHttpsUrl = request.url.newBuilder().scheme("https").build()
            requestBuilder.url(newHttpsUrl)
        }
        return chain.proceed(requestBuilder.build())
    }
}