package com.appnroll.recruitment.viper.country_details.list

import com.appnroll.recruitment.view._base.BaseRecyclerAdapter
import com.appnroll.recruitment.view._base.ListingItem
import com.appnroll.recruitment.viper.country_details.list.aggregate.COUNTRY_DETAILS_ITEM_TYPE
import com.appnroll.recruitment.viper.country_details.list.delegate.CountryDetailsAdapterDelegate
import com.hannesdorfmann.adapterdelegates3.AdapterDelegatesManager

class CountryDetailsAdapter : BaseRecyclerAdapter<ListingItem>() {

    override fun addAdapterDelegates(delegatesManager: AdapterDelegatesManager<List<ListingItem>>) {
        delegatesManager.addDelegate(COUNTRY_DETAILS_ITEM_TYPE, CountryDetailsAdapterDelegate())
    }
}
