package com.appnroll.recruitment.viper.country_details.list.view_holder

import android.support.v7.widget.RecyclerView
import android.view.View
import com.appnroll.recruitment.viper.country_details.list.aggregate.CountryDetailsItem
import kotlinx.android.synthetic.main.viewholder_country_details_item.view.*

class CountryDetailsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun bind(item: CountryDetailsItem) {
        itemView.run {
            header.text = item.header
            description.text = item.descriptions.joinToString()
        }
    }
}
