package com.appnroll.recruitment.data.remote.model

import com.google.gson.annotations.SerializedName

data class CurrencyRemote(@SerializedName("code") val id: String?,
                          val name: String?,
                          val symbol: String?)
