package com.space.quiz_app.presentation

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.RectF
import android.view.View

class CustomView(context: Context) : View(context) {

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        val screenHeight = height.toFloat()
        val halfScreenHeight = screenHeight / 2f

        val rect = RectF(0f, halfScreenHeight, width.toFloat(), screenHeight)
        val cornerRadius = 20f

        val paint = Paint().apply {
            color = Color.BLUE
            style = Paint.Style.FILL
        }

        canvas.drawRoundRect(rect, cornerRadius, cornerRadius, paint)
    }
}
