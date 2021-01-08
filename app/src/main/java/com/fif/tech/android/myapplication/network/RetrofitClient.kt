package com.fif.tech.android.myapplication.network

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by JGarcia on 29-10-20.
 */
object RetrofitClient {

    val URL = "https://swapi.dev/"

    var mySWClient: StarwarsService

    init {
        val client = OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor()) //Agregamos logger
            .build()
        mySWClient = Retrofit.Builder().apply {
            client(client)
            baseUrl(URL)
            addConverterFactory(GsonConverterFactory.create())
        }.build().create(StarwarsService::class.java)
    }

}