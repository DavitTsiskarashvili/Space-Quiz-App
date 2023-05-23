package com.space.quiz_app.presentation.custom_view

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Path
import android.util.AttributeSet
import com.space.quiz_app.R

// A custom view representing a blue background with rounded corners for questions
class QuizQuestionBackgroundView(
    context: Context,
    attrs: AttributeSet
) : QuizBaseCustomView(context, attrs) {

    override val paint = Paint().apply {
        style = Paint.Style.FILL
    }

    /**[drawBackground] Draws the background of the custom view on the canvas
     */
    override fun drawBackground(canvas: Canvas) {
        //The x-coordinate of the center for the first circle.
        val centerX1 = width / 4
        //The x-coordinate of the center for the second circle.
        val centerX2 = width * 3 / 4
        val radius = width / 4
        val centerY = height - radius

        path.apply {
            reset()
            paint.color = context.getColor(R.color.blue_secondary_lightest)
            addCircle(centerX1, centerY, radius, Path.Direction.CW)
            addCircle(centerX2, centerY, radius, Path.Direction.CW)

            moveTo(0f, 0f)
            lineTo(width, 0f)
            lineTo(width, centerY)
            lineTo(centerX2, height)

            lineTo(centerX1, height)
            lineTo(0f, centerY)
            lineTo(0f, 0f)
            close()
        }
        canvas.drawPath(path, paint)
    }

    override fun onBind(canvas: Canvas) {
        drawBackground(canvas)
    }
}