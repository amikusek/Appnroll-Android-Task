package com.appnroll.recruitment.viper.country_details

import android.graphics.Color
import android.support.v7.widget.LinearLayoutManager
import android.webkit.WebSettings
import com.appnroll.recruitment.R
import com.appnroll.recruitment.data.entity.Country
import com.appnroll.recruitment.utils.constants.COUNTRY_ARGS
import com.appnroll.recruitment.viper.country_details.list.CountryDetailsAdapter
import com.appnroll.recruitment.viper.country_details.list.aggregate.CountryDetailsItem
import com.mateuszkoslacz.moviper.base.view.activity.autoinject.passive.ViperAiPassiveActivity
import kotlinx.android.synthetic.main.activity_country_details.*

class CountryDetailsActivity : ViperAiPassiveActivity<CountryDetailsContract.View>(), CountryDetailsContract.View {

    private val country: Country?
        get() = args.getParcelable(COUNTRY_ARGS)
    private val adapter = CountryDetailsAdapter()

    override fun injectViews() {
        super.injectViews()
        setReyclerView()
        setUpToolbar()
        render()
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    private fun setUpToolbar() {
        supportActionBar?.let {
            it.setDisplayHomeAsUpEnabled(true)
            it.setDisplayShowHomeEnabled(true)
            it.title = country?.name ?: ""
        }
    }

    private fun render() {
        country?.let {
            showFlag()
            adapter.listingItems = mutableListOf<CountryDetailsItem>().apply {
                add(CountryDetailsItem("Currencies", it.currencies.map { "${it.name} (${it.id})" }))
                add(CountryDetailsItem("Domains", it.domains))
                add(CountryDetailsItem("Calling Codes", it.callingCodes.map { "+$it" }))
            }
        }
    }

    // I'm displaying flag image in WebView because Android (and third-part libraries like Glide and
    // Picasso) has no support for SVG files directly.
    // I've spent some time for research, but there was no perfect solution.
    // For example: https://ferdinand-muetsch.de/how-to-load-svg-into-imageview-by-url-in-android.html
    // In most cases, there were a lot of errors while converting svg files provided by remote API.
    // Finally I'm not sure if it's the most important part of this task, so I've decided to
    // not spending more time on this and stay with WebView solution.
    private fun showFlag() {
        flagHolder.loadData("<html>\n" +
                "<body>\n" +
                "<center>\n" +
                "<img src=\"${country?.flagUrl}\" width=\"300\" height=\"200\">\n" +
                "</center>\n" +
                "</html>", "text/html", "UTF-8")
        flagHolder.setBackgroundColor(Color.TRANSPARENT)
    }

    private fun setReyclerView() {
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
    }

    override fun createPresenter() = CountryDetailsPresenter()

    override fun getLayoutId() = R.layout.activity_country_details
}
