package com.appnroll.recruitment.data.local.dao

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import com.appnroll.recruitment.data.local.model.DomainDB
import io.reactivex.Flowable

@Dao
interface DomainsDao {

    @Query("SELECT * FROM country_domains WHERE :countryId = countryId")
    fun getDomainsFromCountry(countryId: String): Flowable<List<DomainDB>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertDomains(domains: List<DomainDB>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertDomain(domain: DomainDB)
}
