package com.space.quiz_app.common.extensions

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.space.quiz_app.R

fun ImageView.loadImage (url: String?) {
    Glide.with(context)
        .load(url)
        .into(this)
}