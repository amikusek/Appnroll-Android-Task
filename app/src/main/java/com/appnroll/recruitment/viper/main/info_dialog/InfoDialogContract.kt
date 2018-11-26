package com.appnroll.recruitment.viper.main.info_dialog

import android.app.Activity

import com.hannesdorfmann.mosby.mvp.MvpView
import com.mateuszkoslacz.moviper.iface.interactor.ViperRxInteractor
import com.mateuszkoslacz.moviper.iface.routing.ViperRxRouting
import io.reactivex.Observable
import org.joda.time.DateTime

interface InfoDialogContract {

    interface View : MvpView {
        fun setDataInfo(lastFetchDate: DateTime)
    }

    interface Interactor : ViperRxInteractor {
        fun getLastDownloadDataDate(): Observable<DateTime>
    }

    interface Routing : ViperRxRouting<Activity>
}
