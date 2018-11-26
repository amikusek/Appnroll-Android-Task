package com.appnroll.recruitment.data.local.model

import android.arch.persistence.room.Entity
import android.arch.persistence.room.ForeignKey
import android.arch.persistence.room.Relation

@Entity(tableName = "countries_currencies",
        primaryKeys = ["countryId", "currencyId"],
        foreignKeys = [
            ForeignKey(entity = CountryDB::class,
                    parentColumns = ["id"],
                    childColumns = ["countryId"]),
            ForeignKey(entity = CurrencyDB::class,
                    parentColumns = ["id"],
                    childColumns = ["currencyId"])
        ]
)
data class CountriesCurrenciesDB(val countryId: String,
                                 val currencyId: String)