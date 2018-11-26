package com.appnroll.recruitment.data.remote.mapper

import com.appnroll.recruitment.data._base.BaseMapper
import com.appnroll.recruitment.data.entity.Currency
import com.appnroll.recruitment.data.remote.model.CurrencyRemote

class CurrencyMapper : BaseMapper<CurrencyRemote, Currency>() {

    override fun mapOrReturnNull(from: CurrencyRemote): Currency? {
        return if (from.id.isNullOrEmpty() && from.name.isNullOrEmpty()) null
        else mapRemote(from)
    }

    fun mapRemote(model: CurrencyRemote) = Currency(
            if (model.id.isNullOrEmpty()) model.name ?: "" else model.id!!,
            model.name ?: "")
}
