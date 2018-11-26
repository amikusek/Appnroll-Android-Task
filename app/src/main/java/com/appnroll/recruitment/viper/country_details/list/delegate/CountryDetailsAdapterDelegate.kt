package com.appnroll.recruitment.viper.country_details.list.delegate

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.appnroll.recruitment.R
import com.appnroll.recruitment.data.entity.Country
import com.appnroll.recruitment.view._base.ListingItem
import com.appnroll.recruitment.viper.country_details.list.aggregate.COUNTRY_DETAILS_ITEM_TYPE
import com.appnroll.recruitment.viper.country_details.list.aggregate.CountryDetailsItem
import com.appnroll.recruitment.viper.country_details.list.view_holder.CountryDetailsViewHolder
import com.hannesdorfmann.adapterdelegates3.AdapterDelegate
import io.reactivex.subjects.PublishSubject

class CountryDetailsAdapterDelegate : AdapterDelegate<List<ListingItem>>() {

    override fun isForViewType(items: List<ListingItem>, position: Int) =
            items[position].type == COUNTRY_DETAILS_ITEM_TYPE

    override fun onCreateViewHolder(parent: ViewGroup) =
            CountryDetailsViewHolder(LayoutInflater
                    .from(parent.context)
                    .inflate(R.layout.viewholder_country_details_item, parent, false))

    override fun onBindViewHolder(items: List<ListingItem>, position: Int,
                                  holder: RecyclerView.ViewHolder,
                                  payloads: List<Any>) {
        (holder as? CountryDetailsViewHolder)?.bind((items[position] as CountryDetailsItem))
    }
}
