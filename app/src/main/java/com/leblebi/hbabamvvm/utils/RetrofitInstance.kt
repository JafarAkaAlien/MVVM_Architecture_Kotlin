package com.leblebi.hbabamvvm.utils

import com.leblebi.hbabamvvm.utils.Constants.BASE_URL
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object RetrofitInstance {
     val INSTANCE by lazy {
        val interceptor = HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }
        val clientBuilder = OkHttpClient.Builder().addInterceptor(interceptor)
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(clientBuilder.build())
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
    }
}