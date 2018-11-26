package com.appnroll.recruitment.data.remote.mapper

import com.appnroll.recruitment.data._base.BaseMapper
import com.appnroll.recruitment.data.entity.Country
import com.appnroll.recruitment.data.remote.model.CountryRemote

class CountryMapper : BaseMapper<CountryRemote, Country>() {

    private val currencyMapper = CurrencyMapper()

    override fun mapOrReturnNull(from: CountryRemote): Country? {
        return if (from.name.isNullOrEmpty() || from.id.isNullOrEmpty()) null
        else mapRemote(from)
    }

    fun mapRemote(model: CountryRemote) = Country(
            model.id!!,
            model.name!!,
            model.flagUrl ?: "",
            model.topLevelDomains?.map { it ?: "" } ?: listOf(),
            currencyMapper.mapOrSkip(model.currencies?.filterNotNull()),
            model.callingCodes?.map { it ?: "" } ?: listOf())
}
