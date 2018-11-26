package com.appnroll.recruitment.viper.main

import com.appnroll.recruitment.data.entity.Country
import com.appnroll.recruitment.data.local.DBManager
import com.appnroll.recruitment.data.local.util.DIProvider
import com.appnroll.recruitment.data.remote.mapper.CountryMapper
import com.appnroll.recruitment.data.remote.model.CountryRemote
import com.appnroll.recruitment.data.sync.SyncableRepository
import com.appnroll.recruitment.data.sync.query.local.GetCountriesFromDbQuery
import com.appnroll.recruitment.data.sync.query.local.SaveCountriesToDbQuery
import com.appnroll.recruitment.data.sync.query.remote.GetCountriesQuery
import com.appnroll.recruitment.extension.observeOnComputation
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.mateuszkoslacz.moviper.base.interactor.BaseRxInteractor
import io.reactivex.Observable
import org.joda.time.DateTime
import org.joda.time.DateTimeZone
import org.joda.time.Hours

class MainInteractor : BaseRxInteractor(), MainContract.Interactor {

    private val countryMapper = CountryMapper()

    private val repository = SyncableRepository()

    override fun getCountries() =
            repository.query(GetCountriesQuery())

    override fun saveCountriesToDb(countries: List<Country>) =
            repository.query(SaveCountriesToDbQuery(countries))

    override fun getCountriesFromDB() =
            repository.query(GetCountriesFromDbQuery())

    override fun isFirstRun() = DIProvider.persistentStorage.isFirstRun

    override fun updateFirstRunFlag() = DIProvider.persistentStorage.saveIsFirstRunFlag(false)

    override fun shouldDataBeDownloadedFromRemote() = Hours.hoursBetween(getLastUploadTime(), DateTime(DateTimeZone.UTC)).hours > 16

    override fun loadCountriesFromLocalJSON(json: String) = Observable
            .just(Gson().fromJson<List<CountryRemote>>(json, object : TypeToken<List<CountryRemote>>() {}.type))
            .observeOnComputation()
            .map { it.map { countryMapper.mapRemote(it) } }
            .flatMap { DBManager().saveCountries(it) }

    override fun getLastUploadTime() =
            DateTime(DIProvider.persistentStorage.lastUpdateTimestamp, DateTimeZone.UTC)

    override fun saveLastDownloadTimestamp(timestamp: DateTime) =
            DIProvider.persistentStorage.saveCountriesUpdateTimestamp(timestamp.millis)
}
