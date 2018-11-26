package com.appnroll.recruitment.viper.main

import com.appnroll.recruitment.extension.observeOnComputation
import com.appnroll.recruitment.extension.observeOnIo
import com.appnroll.recruitment.extension.observeOnMain
import com.appnroll.recruitment.extension.retrySubscribe
import com.mateuszkoslacz.moviper.base.presenter.BaseRxPresenter
import com.mateuszkoslacz.moviper.iface.presenter.ViperPresenter
import io.reactivex.subjects.PublishSubject
import org.joda.time.DateTime
import org.joda.time.DateTimeZone

class MainPresenter : BaseRxPresenter<MainContract.View, MainContract.Interactor,
        MainContract.Routing>(), ViperPresenter<MainContract.View> {

    private val loadInitData = PublishSubject.create<Any>()
    private val loadLocalData = PublishSubject.create<Any>()
    private val loadRemoteData = PublishSubject.create<Any>()

    override fun attachView(attachingView: MainContract.View?) {
        super.attachView(attachingView)

        addSubscription(
                loadLocalData
                        .doOnNext { view!!.showLoading() }
                        .observeOnComputation()
                        .flatMap { interactor.getCountriesFromDB() }
                        .observeOnMain()
                        .retrySubscribe(
                                onNext = {
                                    view?.setList(it)
                                    view?.showList()
                                    loadRemoteData.onNext(Unit)
                                },
                                onError = {
                                    view?.showError(it)
                                    it.printStackTrace()
                                }))
        addSubscription(
                loadRemoteData
                        .filter { interactor.shouldDataBeDownloadedFromRemote() }
                        .observeOnIo()
                        .flatMap { interactor.getCountries() }
                        .observeOnMain()
                        .doOnNext { view?.setList(it) }
                        .observeOnComputation()
                        .flatMap { interactor.saveCountriesToDb(it) }
                        .observeOnMain()
                        .doOnNext { interactor.saveLastDownloadTimestamp(DateTime(DateTimeZone.UTC)) }
                        .retrySubscribe(onNext = {}))
        addSubscription(
                view!!
                        .onCountryListItemClicksEvents
                        .retrySubscribe(
                                onNext = { routing.startCountryDetailsScreen(it) },
                                onError = { it.printStackTrace() }))
        addSubscription(
                loadInitData
                        .doOnNext { view!!.showLoading() }
                        .flatMap { routing.getCountriesFromFile() }
                        .observeOnComputation()
                        .flatMap { interactor.loadCountriesFromLocalJSON(it) }
                        .observeOnMain()
                        .doOnNext { interactor.updateFirstRunFlag() }
                        .doOnNext { interactor.saveLastDownloadTimestamp(DateTime(2018, 11, 25, 22, 0, DateTimeZone.UTC)) }
                        .retrySubscribe(
                                onNext = { loadLocalData.onNext(Unit) },
                                onError = { it.printStackTrace() }))

        if (interactor.isFirstRun())
            loadInitData.onNext(Unit)
        else
            loadLocalData.onNext(Unit)
    }

    override fun createRouting() = MainRouting()

    override fun createInteractor() = MainInteractor()
}
