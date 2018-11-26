package com.appnroll.recruitment.viper.main

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import com.appnroll.recruitment.data.entity.Country
import com.appnroll.recruitment.utils.constants.COUNTRY_ARGS
import com.appnroll.recruitment.utils.constants.INFO_DIALOG_TAG
import com.appnroll.recruitment.viper.country_details.CountryDetailsActivity
import com.appnroll.recruitment.viper.main.info_dialog.InfoDialogFragment
import com.mateuszkoslacz.moviper.base.routing.BaseRxRouting
import io.reactivex.Observable

class MainRouting : BaseRxRouting<AppCompatActivity>(), MainContract.Routing {

    override fun showInfoDialog() {
        relatedContext?.let {
            InfoDialogFragment().show(relatedContext?.supportFragmentManager, INFO_DIALOG_TAG)
        }
    }

    override fun startCountryDetailsScreen(country: Country) {
        relatedContext?.let {
            it.startActivity(Intent(it, CountryDetailsActivity::class.java).apply {
                putExtra(COUNTRY_ARGS, country)
            })
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
