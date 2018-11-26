package com.appnroll.recruitment.data.sync

import com.appnroll.recruitment.data.remote.ApiManager
import com.appnroll.recruitment.data.sync.query._base.RemoteQuery

class SyncableRepository {

    private val apiManager = ApiManager()

    fun <Entity> query(query: RemoteQuery<Entity>) = query.executeRemote(apiManager)
}
