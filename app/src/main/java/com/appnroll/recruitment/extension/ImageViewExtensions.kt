package com.appnroll.recruitment.extension

import android.widget.ImageView
import com.bumptech.glide.Glide

fun ImageView.loadUrl(url: String?) {
    if (url.isNullOrEmpty()) setImageDrawable(null)
    else Glide.with(context).load(url).into(this)
}
