package com.appnroll.recruitment.data.sync.query.local

import com.appnroll.recruitment.data.entity.Country
import com.appnroll.recruitment.data.local.DBManager
import com.appnroll.recruitment.data.sync.query._base.LocalQuery

class GetCountriesFromDbQuery : LocalQuery<List<Country>> {

    override fun executeLocal(dbManager: DBManager) = dbManager.getCountries()
}
