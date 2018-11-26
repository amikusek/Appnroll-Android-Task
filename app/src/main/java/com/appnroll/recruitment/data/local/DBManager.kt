package com.appnroll.recruitment.data.local

import android.arch.persistence.room.Room
import com.appnroll.recruitment.data.entity.Country
import com.appnroll.recruitment.data.entity.Currency
import com.appnroll.recruitment.data.local.mapper.CountryDbMapper
import com.appnroll.recruitment.data.local.model.CallingCodeDB
import com.appnroll.recruitment.data.local.model.CountriesCurrenciesDB
import com.appnroll.recruitment.data.local.model.CurrencyDB
import com.appnroll.recruitment.data.local.model.DomainDB
import com.appnroll.recruitment.extension.asObservable
import com.appnroll.recruitment.utils.AppContextHolder
import com.appnroll.recruitment.utils.constants.DB_NAME
import io.reactivex.Completable

class DBManager {

    private val countryMapper = CountryDbMapper()

    private val db = Room
            .databaseBuilder(AppContextHolder.context, AppDatabase::class.java, DB_NAME)
            .build()

    fun saveCountries(countries: List<Country>) =
            Completable.fromCallable {
                countries.forEach { country ->
                    db
                            .countriesDao()
                            .insertCountry(countryMapper.mapToLocal(country))

                    saveCallingCodes(country.id, country.callingCodes)
                    saveDomains(country.id, country.domains)
                    saveCurrencies(country.currencies)
                    saveCountriesCurrencies(country.id, country.currencies)
                }
            }
                    .toSingleDefault(Unit)
                    .toObservable()!!

    fun saveCallingCodes(countryId: String, callingCodes: List<String>) =
            db
                    .callingCodesDao()
                    .insertCallingCodes(callingCodes.map { CallingCodeDB(it, countryId) })

    fun saveDomains(countryId: String, domains: List<String>) =
            db
                    .domainsDao()
                    .insertDomains(domains.map { DomainDB(it, countryId) })

    fun saveCurrencies(currencies: List<Currency>) =
            db
                    .currenciesDao()
                    .insertCurrencies(currencies.map { CurrencyDB(it.id, it.name) })

    fun saveCountriesCurrencies(countryId: String, currencies: List<Currency>) {
        currencies.forEach { currency ->
            db
                    .countriesCurrenciesDao()
                    .insertCountriesCurrencies(CountriesCurrenciesDB(countryId, currency.id))
        }
    }

    fun getCountries() =
            db
                    .countriesDao()
                    .getCountries()
                    .asObservable()
                    .map { it.map { countryMapper.mapToEntity(it) } }
                    .map { countries ->
                        countries.forEach { it.currencies = db.countriesDao().getCurrenciesOfCountry(it.id).map { Currency(it.id, it.name) } }
                        countries
                    }
}
