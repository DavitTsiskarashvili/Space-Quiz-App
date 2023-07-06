package com.example.corecommon.common.extensions

fun Float.roundToSingleDecimal(): Float {
    return String.format("%.1f", this).toFloat()
}