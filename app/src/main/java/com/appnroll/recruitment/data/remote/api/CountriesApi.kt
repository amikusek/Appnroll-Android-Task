package com.appnroll.recruitment.data.remote.api

import com.appnroll.recruitment.data.remote.model.CountryRemote
import io.reactivex.Observable
import retrofit2.http.GET

interface CountriesApi {

    @GET("/rest/v2/all")
    fun getCountries(): Observable<List<CountryRemote>>
}
