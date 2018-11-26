package com.appnroll.recruitment.data.sync.query._base

import com.appnroll.recruitment.data.local.DBManager
import io.reactivex.Observable

interface LocalQuery<Entity> : Query {

    fun executeLocal(dbManager: DBManager): Observable<Entity>
}
