package com.appnroll.recruitment.viper.country_details

import android.app.Activity

import com.hannesdorfmann.mosby.mvp.MvpView
import com.mateuszkoslacz.moviper.iface.interactor.ViperRxInteractor
import com.mateuszkoslacz.moviper.iface.routing.ViperRxRouting

interface CountryDetailsContract {

    interface View : MvpView

    interface Interactor : ViperRxInteractor

    interface Routing : ViperRxRouting<Activity>
}
