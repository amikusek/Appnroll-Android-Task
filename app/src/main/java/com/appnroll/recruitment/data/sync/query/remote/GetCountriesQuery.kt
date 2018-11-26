package com.appnroll.recruitment.data.sync.query.remote

import com.appnroll.recruitment.data.entity.Country
import com.appnroll.recruitment.data.remote.ApiManager
import com.appnroll.recruitment.data.sync.query._base.RemoteQuery

class GetCountriesQuery : RemoteQuery<List<Country>> {

    override fun executeRemote(apiManager: ApiManager) = apiManager.getCountries()
}
