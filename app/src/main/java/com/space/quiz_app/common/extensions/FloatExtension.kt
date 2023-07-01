package com.space.quiz_app.common.extensions

fun Float.roundToSingleDecimal(): Float {
    return String.format("%.1f", this).toFloat()
}