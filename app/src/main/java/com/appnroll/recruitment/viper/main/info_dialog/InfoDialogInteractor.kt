package com.appnroll.recruitment.viper.main.info_dialog

import com.appnroll.recruitment.data.local.util.DIProvider
import com.mateuszkoslacz.moviper.base.interactor.BaseRxInteractor
import io.reactivex.Observable
import org.joda.time.DateTime
import org.joda.time.DateTimeZone

class InfoDialogInteractor : BaseRxInteractor(), InfoDialogContract.Interactor {

    override fun getLastDownloadDataDate() = Observable.just(
            DateTime(DIProvider.persistentStorage.lastUpdateTimestamp,
                    DateTimeZone.UTC))
}
