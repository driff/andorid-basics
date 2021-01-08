package com.fif.tech.android.myapplication.network

import com.fif.tech.android.myapplication.entities.ListResults
import com.fif.tech.android.myapplication.entities.People
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by JGarcia on 29-10-20.
 */

interface StarwarsService {

    @GET("api/people/")
    suspend fun getPeople(@Query("page") page: Int = 1): ListResults<People>

    // TODO 1: add GET for "api/species/"
    // TODO 2: add GET for "api/planets/"
    // TODO 3: add GET for "api/vehicles/"
    // TODO 4: add GET for "api/spaceships/"

}