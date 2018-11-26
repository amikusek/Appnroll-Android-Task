package com.appnroll.recruitment.viper.main

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import com.appnroll.recruitment.data.entity.Country
import com.mateuszkoslacz.moviper.base.routing.BaseRxRouting
import io.reactivex.Observable

class MainRouting : BaseRxRouting<AppCompatActivity>(), MainContract.Routing {

    override fun startCountryDetailsScreen(country: Country) {
        relatedContext?.let {
            // TODO
        }
    }

    override fun getCountriesFromFile(): Observable<String> {
        var json = ""
        relatedContext?.resources?.assets?.open("json/countries.json").run {
            val buffer = ByteArray(this?.available() ?: 0)
            this?.read(buffer)
            this?.close()
            json = String(buffer)
        }
        return Observable.just(json)
    }
}
