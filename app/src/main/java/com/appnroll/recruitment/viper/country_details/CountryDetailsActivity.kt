package com.appnroll.recruitment.viper.country_details

import com.appnroll.recruitment.R
import com.mateuszkoslacz.moviper.base.view.activity.autoinject.passive.ViperAiPassiveActivity
import com.mateuszkoslacz.moviper.iface.presenter.ViperPresenter

class CountryDetailsActivity : ViperAiPassiveActivity<CountryDetailsContract.View>(), CountryDetailsContract.View {

    override fun createPresenter() = CountryDetailsPresenter()

    override fun getLayoutId() = R.layout.activity_country_details
}
