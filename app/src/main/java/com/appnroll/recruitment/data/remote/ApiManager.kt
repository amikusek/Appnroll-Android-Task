package com.appnroll.recruitment.data.remote

import com.appnroll.recruitment.data.remote.api.CountriesApi
import com.appnroll.recruitment.data.remote.mapper.CountryMapper

class ApiManager {

    private val retrofitFactory = RetrofitFactory()

    private val countryMapper = CountryMapper()

    fun getCountries() = getApi(CountriesApi::class.java)
            .getCountries()
            .map { countryMapper.mapOrSkip(it) }

    private fun <T> getApi(clazz: Class<T>) = retrofitFactory.retrofit.create(clazz)
}
