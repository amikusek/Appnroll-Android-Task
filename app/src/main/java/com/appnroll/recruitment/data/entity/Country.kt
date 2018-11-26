package com.appnroll.recruitment.data.entity

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Country(val id: String,
                   val name: String,
                   val flagUrl: String,
                   val domains: List<String>,
                   var currencies: List<Currency>,
                   val callingCodes: List<String>) : Parcelable
