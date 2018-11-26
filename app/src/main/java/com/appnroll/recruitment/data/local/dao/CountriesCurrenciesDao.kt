package com.appnroll.recruitment.data.local.dao

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import com.appnroll.recruitment.data.local.model.CountriesCurrenciesDB
import io.reactivex.Flowable

@Dao
interface CountriesCurrenciesDao {

    @Query("SELECT * FROM countries_currencies")
    fun getCurrenciesFromCountry(): Flowable<List<CountriesCurrenciesDB>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertCountriesCurrencies(relation: CountriesCurrenciesDB)
}
