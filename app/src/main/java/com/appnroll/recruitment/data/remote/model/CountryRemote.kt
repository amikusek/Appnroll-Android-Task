package com.appnroll.recruitment.data.remote.model

import com.google.gson.annotations.SerializedName

data class CountryRemote(@SerializedName("alpha3Code") val id: String?,
                         val name: String?,
                         val callingCodes: List<String?>?,
                         val currencies: List<CurrencyRemote?>?,
                         @SerializedName("topLevelDomain") val topLevelDomains: List<String?>?,
                         @SerializedName("flag") val flagUrl: String?)
