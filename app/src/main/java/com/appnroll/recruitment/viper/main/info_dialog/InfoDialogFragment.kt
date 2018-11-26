package com.appnroll.recruitment.viper.main.info_dialog

import com.appnroll.recruitment.R
import com.appnroll.recruitment.utils.getFormatedStringFromDate
import com.appnroll.recruitment.view.viper.dialog.ViperAiPassiveDialog
import kotlinx.android.synthetic.main.dialog_info.*
import org.joda.time.DateTime

class InfoDialogFragment : ViperAiPassiveDialog<InfoDialogContract.View>(), InfoDialogContract.View {

    override fun setDataInfo(lastFetchDate: DateTime) {
        lastDataFetchDate.text = getString(R.string.dialog_info_last_fetch_date, getFormatedStringFromDate(lastFetchDate))
        nextDataFetchDate.text = getString(R.string.dialog_info_next_fetch_date, getFormatedStringFromDate(lastFetchDate.withDurationAdded(16, 3600000)))
    }

    override fun createPresenter() = InfoDialogPresenter()

    override fun getLayoutId() = R.layout.dialog_info
}
