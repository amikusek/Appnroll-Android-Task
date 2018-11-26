package com.appnroll.recruitment.data.local.dao

import android.arch.persistence.room.*
import com.appnroll.recruitment.data.local.model.CountryDB
import com.appnroll.recruitment.data.local.model.CurrencyDB
import com.appnroll.recruitment.data.local.model.FullCountryDB
import io.reactivex.Completable
import io.reactivex.Flowable

@Dao
interface CountriesDao {

    @Query("SELECT * FROM countries")
    fun getCountries(): List<FullCountryDB>

    @Query("SELECT * FROM countries_currencies INNER JOIN country_currencies ON countries_currencies.currencyId=country_currencies.id WHERE countries_currencies.countryId=:countryId")
    fun getCurrenciesOfCountry(countryId: String): List<CurrencyDB>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertCountries(countries: List<CountryDB>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertCountry(country: CountryDB)
}
