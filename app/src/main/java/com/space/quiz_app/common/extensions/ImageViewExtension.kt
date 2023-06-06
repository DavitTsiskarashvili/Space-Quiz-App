package com.space.quiz_app.common.extensions

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.space.quiz_app.R

fun ImageView.loadImage (url: String?) {
    Glide.with(context)
        .load("https://run.mocky.io/$url")
        .placeholder(R.drawable.ic_launcher_background)
        .error(R.drawable.ic_launcher_background)
        .into(this)
}