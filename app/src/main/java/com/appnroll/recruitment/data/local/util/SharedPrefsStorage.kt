package com.appnroll.recruitment.data.local.util

import android.content.Context
import com.appnroll.recruitment.utils.constants.FIRST_RUN_FLAG_STORE_LOCATION
import com.appnroll.recruitment.utils.constants.SHARED_PREFS_LOCATION
import com.appnroll.recruitment.utils.constants.UPDATE_TIMESTAMP_STORE_LOCATION
import java.util.*

class SharedPrefsStorage(val context: Context) : PersistentStorage {

    private val sharedPreferences by lazy {
        context.getSharedPreferences(SHARED_PREFS_LOCATION, Context.MODE_PRIVATE)
    }

    override val lastUpdateTimestamp
        get() = sharedPreferences.getLong(UPDATE_TIMESTAMP_STORE_LOCATION, Date().time)

    override val isFirstRun
        get() = sharedPreferences.getBoolean(FIRST_RUN_FLAG_STORE_LOCATION, true)

    override fun saveCountriesUpdateTimestamp(timestamp: Long) =
            sharedPreferences
                    .edit()
                    .putLong(UPDATE_TIMESTAMP_STORE_LOCATION, timestamp)
                    .apply()

    override fun saveIsFirstRunFlag(flag: Boolean) =
            sharedPreferences
                    .edit()
                    .putBoolean(FIRST_RUN_FLAG_STORE_LOCATION, flag)
                    .apply()
}
