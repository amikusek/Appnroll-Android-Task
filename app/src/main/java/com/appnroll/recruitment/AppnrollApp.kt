package com.appnroll.recruitment

import android.app.Application
import android.content.Context
import android.util.Log
import com.appnroll.recruitment.data.local.util.DIProvider
import com.appnroll.recruitment.utils.AppContextHolder
import com.facebook.stetho.Stetho
import com.mateuszkoslacz.moviper.presenterbus.Config
import com.mateuszkoslacz.moviper.presenterbus.Moviper

class AppnrollApp : Application() {

    override fun onCreate() {
        super.onCreate()
        initMoviper()
        initDIProvider(this)
        AppContextHolder.init(this)
        Stetho.initializeWithDefaults(this)
    }

    private fun initDIProvider(context: Context) = DIProvider.init(context)

    private fun initMoviper() {
        Moviper.getInstance().setConfig(
                Config.newBuilder()
                        .withInstancePresentersEnabled(true)
                        .withPresenterAccessUtilEnabled(true)
                        .build())
        Moviper.getInstance().setErrorHandler { Log.e("MoveApp", "", it) }
    }
}
