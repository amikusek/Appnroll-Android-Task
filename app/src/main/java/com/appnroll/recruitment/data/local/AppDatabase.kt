package com.appnroll.recruitment.data.local

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import com.appnroll.recruitment.data.local.dao.*
import com.appnroll.recruitment.data.local.model.*

@Database(entities = [(CountryDB::class), (CurrencyDB::class), (DomainDB::class),
    (CallingCodeDB::class), (CountriesCurrenciesDB::class)],
        version = 1,
        exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract fun countriesDao(): CountriesDao
    abstract fun currenciesDao(): CurrenciesDao
    abstract fun countriesCurrenciesDao(): CountriesCurrenciesDao
    abstract fun domainsDao(): DomainsDao
    abstract fun callingCodesDao(): CallingCodesDao
}
