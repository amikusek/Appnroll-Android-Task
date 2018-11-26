package com.appnroll.recruitment.data.local.model

import android.arch.persistence.room.Embedded
import android.arch.persistence.room.Entity
import android.arch.persistence.room.Relation

class FullCountryDB {

    @Embedded
    var country: CountryDB? = null

    @Relation(parentColumn = "id", entityColumn = "countryId", entity = CallingCodeDB::class)
    var callingCodes: List<CallingCodeDB>? = null

    @Relation(parentColumn = "id", entityColumn = "countryId", entity = DomainDB::class)
    var domains: List<DomainDB>? = null
}
