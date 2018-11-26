package com.appnroll.recruitment.viper.main.list.view_holder

import android.support.v7.widget.RecyclerView
import android.view.View
import com.appnroll.recruitment.data.entity.Country
import com.appnroll.recruitment.extension.retrySubscribe
import com.appnroll.recruitment.extension.throttleClicks
import com.appnroll.recruitment.viper.main.list.aggregate.CountryListItem
import kotlinx.android.synthetic.main.viewholder_country.view.*
import io.reactivex.disposables.Disposable
import io.reactivex.subjects.PublishSubject

class CountryViewHolder(itemView: View, val itemClicks: PublishSubject<Country>) : RecyclerView.ViewHolder(itemView) {

    private var clicksDisposable: Disposable? = null

    fun bind(item: CountryListItem) {
        itemView.run {
            name.text = item.country.name

            clicksDisposable = itemView
                    .throttleClicks()
                    .retrySubscribe(onNext = { itemClicks.onNext(item.country) })
        }
    }

    fun unbind() = clicksDisposable?.dispose()
}
