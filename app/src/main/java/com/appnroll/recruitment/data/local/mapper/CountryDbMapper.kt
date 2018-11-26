package com.appnroll.recruitment.data.local.mapper

import com.appnroll.recruitment.data._base.BaseMapper
import com.appnroll.recruitment.data.entity.Country
import com.appnroll.recruitment.data.local.model.CountryDB
import com.appnroll.recruitment.data.local.model.FullCountryDB

class CountryDbMapper : BaseMapper<Country, CountryDB>() {

    override fun mapOrReturnNull(from: Country) = mapToLocal(from)

    fun mapToLocal(entity: Country) = CountryDB(
            entity.id,
            entity.name,
            entity.flagUrl)

    fun mapToEntity(local: FullCountryDB) = Country(
            local.country?.id ?: "",
            local.country?.name ?: "",
            local.country?.flagUrl ?: "",
            local.domains?.map { it.name } ?: listOf(),
            listOf(),
            local.callingCodes?.map { it.code } ?: listOf()
    )
}
