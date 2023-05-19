package com.space.quiz_app.presentation.custom_view

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Path
import android.util.AttributeSet
import com.space.quiz_app.R

// A custom view representing a start blue background with corner and circle shapes
class CustomStartBackground(
    context: Context,
    attrs: AttributeSet
) : BaseCustomView(context, attrs) {

    override val paint = Paint().apply {
        style = Paint.Style.FILL
    }

    private val centerX get() = width / 2
    private val radius get() = width / 2

    // Draws the background of the custom view on the canvas
    override fun drawBackground(canvas: Canvas) {
        val heightDiff = (width / 2) - (height / 3)
        val centerY1 = height / 3 + heightDiff
        val centerY2 = height * 2 / 3 - heightDiff

        path.apply {
            reset()
            paint.color = context.getColor(R.color.blue_secondary_light)
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
            canvas.drawPath(path, paint)
        }
    }
    // Draws the corner shape on the canvas
    private fun drawCorner(canvas: Canvas) {
        path.apply {
            reset()
            paint.color = context.getColor(R.color.blue_secondary_default)
            moveTo(0f, 0f)
            lineTo(centerX, 0f)
            lineTo(0f, height / 2)
            close()
            canvas.drawPath(path, paint)
        }
    }

    override fun onBind(canvas: Canvas) {
        drawCorner(canvas)
        drawBackground(canvas)
    }
}