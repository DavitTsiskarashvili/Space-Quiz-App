package com.space.quiz_app.presentation.ui.login.custom_view

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.RectF
import android.util.AttributeSet
import com.space.quiz_app.R
import com.space.quiz_app.presentation.feature.base.custom_view.QuizBaseCustomView

class QuizLoginBackgroundView(
    context: Context,
    attrs: AttributeSet
) : QuizBaseCustomView(context, attrs) {

    override val paint = Paint().apply {
        style = Paint.Style.FILL
    }

    private val radius get() = width

    /**[drawBackground] Draws the background of the custom view on the canvas
     */
    override fun drawBackground(canvas: Canvas) {

        path.apply {
            reset()
            paint.color = context.getColor(R.color.blue_secondary_light)
            val topRectF = RectF(0f, 0f, radius, radius)
            val bottomRectF = RectF(width - radius, height - radius, width, height)

            // extra line to
            moveTo(width, 0f)
            lineTo(width, radius)
            //draws arc at the right bottom side
            arcTo(bottomRectF, 0f, 90f)
            lineTo(0f, height)
            lineTo(0f, radius)
            //draws arc at the top left side
            arcTo(topRectF, 180f, 90f)
            close()
            canvas.drawPath(path, paint)
        }
    }

    // Draws the triangle in upper left corner
    private fun drawTriangle(canvas: Canvas) {
        path.apply {
            reset()
            paint.color = context.getColor(R.color.blue_secondary_default)
            moveTo(0f, 0f)
            lineTo(width, 0f)
            lineTo(0f, height)
            close()
            canvas.drawPath(path, paint)
        }
    }

    override fun onBind(canvas: Canvas) {
        drawTriangle(canvas)
        drawBackground(canvas)
    }

}