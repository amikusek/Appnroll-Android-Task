package com.appnroll.recruitment.viper.main.list.aggregate

import com.appnroll.recruitment.data.entity.Country
import com.appnroll.recruitment.view._base.ListingItem

val COUNTRY_ITEM_TYPE = CountryListItem::class.java.hashCode()

data class CountryListItem(val country: Country) : ListingItem {

    override val type = COUNTRY_ITEM_TYPE
}