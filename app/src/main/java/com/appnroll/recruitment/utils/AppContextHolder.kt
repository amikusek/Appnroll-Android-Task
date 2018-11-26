package com.appnroll.recruitment.utils

import android.annotation.SuppressLint
import android.content.Context

@SuppressLint("StaticFieldLeak")
object AppContextHolder {

    private lateinit var context: Context

    fun init(context: Context) {
        AppContextHolder.context = context
    }
}
