package com.appnroll.recruitment.data.local.dao

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import com.appnroll.recruitment.data.local.model.CurrencyDB
import io.reactivex.Flowable

@Dao
interface CurrenciesDao {

    @Query("SELECT * FROM country_currencies")
    fun getCurrencies(): Flowable<List<CurrencyDB>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertCurrencies(currencies: List<CurrencyDB>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertCurrency(currency: CurrencyDB)
}
