package com.appnroll.recruitment.data.local.dao

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import com.appnroll.recruitment.data.local.model.CallingCodeDB
import com.appnroll.recruitment.data.local.model.CountryDB
import io.reactivex.Flowable

@Dao
interface CallingCodesDao {

    @Query("SELECT * FROM country_calling_codes WHERE :countryId = countryId")
    fun getCallingCodesFromCountry(countryId: String): Flowable<List<CallingCodeDB>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertCallingCodes(callingCodes: List<CallingCodeDB>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertCallingCode(callingCode: CallingCodeDB)
}
