package com.appnroll.recruitment.viper.main

import android.support.v4.content.ContextCompat
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import com.appnroll.recruitment.R
import com.appnroll.recruitment.data.entity.Country
import com.appnroll.recruitment.extension.gone
import com.appnroll.recruitment.extension.visible
import com.appnroll.recruitment.viper.main.list.CountryListAdapter
import com.appnroll.recruitment.viper.main.list.aggregate.CountryListItem
import com.mateuszkoslacz.moviper.base.view.activity.autoinject.passive.ViperAiPassiveActivity
import io.reactivex.Observable
import io.reactivex.subjects.PublishSubject
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : ViperAiPassiveActivity<MainContract.View>(), MainContract.View {

    private var adapter = CountryListAdapter()

    override val infoBtnClicksEvents = PublishSubject.create<Any>()
    override val onCountryListItemClicksEvents: Observable<Country>
        get() = adapter.itemClicks

    override fun injectViews() {
        super.injectViews()
        setRecyclerView()
    }

    override fun setList(countries: List<Country>) {
        recyclerView.adapter = adapter
        adapter.listingItems = countries.map { CountryListItem(it) }
    }

    override fun showLoading() {
        loadingView.visible()
        recyclerView.gone()
        errorView.gone()
    }

    override fun showList() {
        loadingView.gone()
        recyclerView.visible()
        errorView.gone()
    }

    override fun showError(throwable: Throwable) {
        loadingView.gone()
        recyclerView.visible()
        errorView.gone()
    }

    private fun setRecyclerView() {
        recyclerView.addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.VERTICAL).apply {
            setDrawable(ContextCompat.getDrawable(context, R.drawable.list_divider)!!)
        })
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_info -> {
                infoBtnClicksEvents.onNext(Unit)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun createPresenter() = MainPresenter()

    override fun getLayoutId() = R.layout.activity_main
}
