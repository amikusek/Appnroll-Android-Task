package com.appnroll.recruitment.viper.main

import android.support.v7.app.AppCompatActivity
import com.appnroll.recruitment.data.entity.Country
import com.hannesdorfmann.mosby.mvp.MvpView
import com.mateuszkoslacz.moviper.iface.interactor.ViperRxInteractor
import com.mateuszkoslacz.moviper.iface.routing.ViperRxRouting
import io.reactivex.Observable
import org.joda.time.DateTime

interface MainContract {

    interface View : MvpView {
        val onCountryListItemClicksEvents: Observable<Country>
        fun setList(countries: List<Country>)
        fun showLoading()
        fun showList()
        fun showError(throwable: Throwable)
    }

    interface Interactor : ViperRxInteractor {
        fun getCountries(): Observable<List<Country>>
        fun saveCountriesToDb(countries: List<Country>): Observable<Unit>
        fun getCountriesFromDB(): Observable<List<Country>>
        fun loadCountriesFromLocalJSON(json: String): Observable<Unit>
        fun isFirstRun(): Boolean
        fun shouldDataBeDownloadedFromRemote(): Boolean
        fun updateFirstRunFlag()
        fun saveLastDownloadTimestamp(timestamp: DateTime)
        fun getLastUploadTime(): DateTime
    }

    interface Routing : ViperRxRouting<AppCompatActivity> {
        fun startCountryDetailsScreen(country: Country)
        fun getCountriesFromFile(): Observable<String>
    }
}
