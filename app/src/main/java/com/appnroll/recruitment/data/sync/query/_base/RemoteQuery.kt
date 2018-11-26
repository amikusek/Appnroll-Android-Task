package com.appnroll.recruitment.data.sync.query._base

import com.appnroll.recruitment.data.remote.ApiManager
import io.reactivex.Observable

interface RemoteQuery<Entity> {

    fun executeRemote(apiManager: ApiManager): Observable<Entity>
}
