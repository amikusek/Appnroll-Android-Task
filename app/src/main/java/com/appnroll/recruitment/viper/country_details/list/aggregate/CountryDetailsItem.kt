package com.appnroll.recruitment.viper.country_details.list.aggregate

import com.appnroll.recruitment.view._base.ListingItem

val COUNTRY_DETAILS_ITEM_TYPE = CountryDetailsItem::class.java.hashCode()

data class CountryDetailsItem(val header: String,
                              val descriptions: List<String>) : ListingItem {

    override val type = COUNTRY_DETAILS_ITEM_TYPE
}
