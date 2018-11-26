package com.appnroll.recruitment.viper.country_details

import com.mateuszkoslacz.moviper.base.presenter.BaseRxPresenter
import com.mateuszkoslacz.moviper.iface.presenter.ViperPresenter

class CountryDetailsPresenter : BaseRxPresenter<CountryDetailsContract.View, CountryDetailsContract.Interactor, CountryDetailsContract.Routing>(), ViperPresenter<CountryDetailsContract.View> {

    override fun createRouting() = CountryDetailsRouting()

    override fun createInteractor() = CountryDetailsInteractor()
}
