package com.appnroll.recruitment.viper.main.info_dialog

import android.content.Context
import com.appnroll.recruitment.extension.retrySubscribe
import com.appnroll.recruitment.view.viper.routing.DummyRoutingObject
import com.mateuszkoslacz.moviper.base.presenter.BaseRxPresenter
import com.mateuszkoslacz.moviper.iface.presenter.ViperPresenter
import com.mateuszkoslacz.moviper.iface.routing.ViperRxRouting
import io.reactivex.subjects.PublishSubject

class InfoDialogPresenter : BaseRxPresenter<InfoDialogContract.View, InfoDialogContract.Interactor,
        ViperRxRouting<Context>>(), ViperPresenter<InfoDialogContract.View> {

    private val loadData = PublishSubject.create<Any>()

    override fun attachView(view: InfoDialogContract.View?) {
        super.attachView(view)

        addSubscription(
                loadData
                        .flatMap { interactor.getLastDownloadDataDate() }
                        .retrySubscribe(
                                onNext = { view?.setDataInfo(it) }))
        loadData.onNext(Unit)
    }

    override fun createRouting() = DummyRoutingObject

    override fun createInteractor() = InfoDialogInteractor()
}
