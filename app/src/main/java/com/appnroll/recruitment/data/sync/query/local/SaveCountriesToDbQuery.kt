package com.appnroll.recruitment.data.sync.query.local

import com.appnroll.recruitment.data.entity.Country
import com.appnroll.recruitment.data.local.DBManager
import com.appnroll.recruitment.data.sync.query._base.LocalQuery

class SaveCountriesToDbQuery(val countries: List<Country>) : LocalQuery<Unit> {

    override fun executeLocal(dbManager: DBManager) = dbManager.saveCountries(countries)
}
