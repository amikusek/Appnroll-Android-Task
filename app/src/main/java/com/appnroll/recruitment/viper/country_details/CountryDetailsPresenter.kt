package com.appnroll.recruitment.viper.country_details

import android.content.Context
import com.appnroll.recruitment.view.viper.interactor.DummyInteractorObject
import com.appnroll.recruitment.view.viper.routing.DummyRoutingObject
import com.mateuszkoslacz.moviper.base.presenter.BaseRxPresenter
import com.mateuszkoslacz.moviper.iface.interactor.ViperRxInteractor
import com.mateuszkoslacz.moviper.iface.presenter.ViperPresenter
import com.mateuszkoslacz.moviper.iface.routing.ViperRxRouting

class CountryDetailsPresenter : BaseRxPresenter<CountryDetailsContract.View,
        ViperRxInteractor, ViperRxRouting<Context>>(),
        ViperPresenter<CountryDetailsContract.View> {

    override fun createRouting() = DummyRoutingObject

    override fun createInteractor() = DummyInteractorObject
}
