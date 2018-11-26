package com.appnroll.recruitment.data.entity

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Currency(val id: String,
                    val name: String) : Parcelable
