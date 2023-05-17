package com.space.quiz_app.presentation.custom_view

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import android.util.AttributeSet
import android.view.View
import com.space.quiz_app.R

class CustomStartBackground(
    context: Context,
    attrs: AttributeSet
) : View(context, attrs) {

    private val fillPaint = Paint().apply {
            style = Paint.Style.FILL
        }

    private val path = Path()
    private val width get() = getWidth().toFloat()
    private val height get() = getHeight().toFloat()
    private val centerX get() = width / 2
    private val radius get() = width / 2

    private fun drawBackground(canvas: Canvas) {
        val heightDiff = (width / 2) - (height / 3)
        val centerY1 = height / 3 + heightDiff
        val centerY2 = height * 2 / 3 - heightDiff

        path.apply {
            reset()
            fillPaint.color = context.getColor(R.color.start_corner)
            addCircle(centerX, centerY1, radius, Path.Direction.CW)
            addCircle(centerX, centerY2, radius, Path.Direction.CW)

            moveTo(centerX, 0f)
            lineTo(width, 0f)
            lineTo(width, centerY2)
            lineTo(centerX, height)
            lineTo(0f, height)
            lineTo(0f, centerY1)
            lineTo(centerX, 0f)
            close()
            canvas.drawPath(path, fillPaint)
        }
    }

    private fun drawCorner(canvas: Canvas) {
        path.apply {
            reset()
            fillPaint.color = context.getColor(R.color.blue_secondary_default)
            moveTo(0f, 0f)
            lineTo(centerX, 0f)
            lineTo(0f, height / 2)
            close()
            canvas.drawPath(path, fillPaint)
        }
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        drawCorner(canvas)
        drawBackground(canvas)
    }

}