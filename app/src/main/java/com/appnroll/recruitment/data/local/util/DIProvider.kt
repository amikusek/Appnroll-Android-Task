package com.appnroll.recruitment.data.local.util

import android.annotation.SuppressLint
import android.content.Context

@SuppressLint("StaticFieldLeak")
object DIProvider {

    private lateinit var context: Context //It will not cause the leak as it is initialized with application context

    fun init(context: Context) {
        DIProvider.context = context
    }

    val persistentStorage: PersistentStorage by lazy {
        SharedPrefsStorage(context = context)
    }

    val applicationContext: Context by lazy {
        context
    }
}
