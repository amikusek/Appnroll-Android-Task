package com.appnroll.recruitment.viper.main.list.delegate

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.appnroll.recruitment.R
import com.appnroll.recruitment.data.entity.Country
import com.appnroll.recruitment.view._base.ListingItem
import com.appnroll.recruitment.viper.main.list.aggregate.COUNTRY_ITEM_TYPE
import com.appnroll.recruitment.viper.main.list.aggregate.CountryListItem
import com.appnroll.recruitment.viper.main.list.view_holder.CountryViewHolder
import com.hannesdorfmann.adapterdelegates3.AdapterDelegate
import io.reactivex.subjects.PublishSubject

class CountryListAdapterDelegate(private val itemClicks: PublishSubject<Country>) : AdapterDelegate<List<ListingItem>>() {

    override fun isForViewType(items: List<ListingItem>, position: Int) =
            items[position].type == COUNTRY_ITEM_TYPE

    override fun onCreateViewHolder(parent: ViewGroup) =
            CountryViewHolder(LayoutInflater
                    .from(parent.context)
                    .inflate(R.layout.viewholder_country, parent, false),
                    itemClicks)

    override fun onBindViewHolder(items: List<ListingItem>, position: Int,
                                  holder: RecyclerView.ViewHolder,
                                  payloads: List<Any>) {
        (holder as? CountryViewHolder)?.bind((items[position] as CountryListItem))
    }

    override fun onViewDetachedFromWindow(holder: RecyclerView.ViewHolder?) {
        (holder as CountryViewHolder).unbind()
        super.onViewDetachedFromWindow(holder)
    }

    override fun onFailedToRecycleView(holder: RecyclerView.ViewHolder): Boolean {
        (holder as CountryViewHolder).unbind()
        return super.onFailedToRecycleView(holder)
    }
}
