package com.example.corecommon.common.extensions

import android.view.View
import android.widget.ImageView
import com.bumptech.glide.Glide

fun View.setVisibility(visible: Boolean) {
    visibility = if (visible) View.VISIBLE else View.GONE
}

fun ImageView.loadImage(url: String?) {
    Glide.with(context)
        .load(url)
        .into(this)
}