package com.appnroll.recruitment.data.local.util

interface PersistentStorage {

    val lastUpdateTimestamp: Long
    val isFirstRun: Boolean
    fun saveCountriesUpdateTimestamp(timestamp: Long)
    fun saveIsFirstRunFlag(flag: Boolean)
}
