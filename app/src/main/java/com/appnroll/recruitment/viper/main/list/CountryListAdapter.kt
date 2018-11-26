package com.appnroll.recruitment.viper.main.list

import com.appnroll.recruitment.data.entity.Country
import com.appnroll.recruitment.view._base.BaseRecyclerAdapter
import com.appnroll.recruitment.view._base.ListingItem
import com.appnroll.recruitment.viper.main.list.aggregate.COUNTRY_ITEM_TYPE
import com.appnroll.recruitment.viper.main.list.delegate.CountryListAdapterDelegate
import com.hannesdorfmann.adapterdelegates3.AdapterDelegatesManager
import io.reactivex.Observable
import io.reactivex.subjects.PublishSubject

class CountryListAdapter : BaseRecyclerAdapter<ListingItem>() {

    private val _itemClicks = PublishSubject.create<Country>()!!
    val itemClicks: Observable<Country> = _itemClicks

    override fun addAdapterDelegates(delegatesManager: AdapterDelegatesManager<List<ListingItem>>) {
        delegatesManager.addDelegate(COUNTRY_ITEM_TYPE, CountryListAdapterDelegate(_itemClicks))
    }
}
