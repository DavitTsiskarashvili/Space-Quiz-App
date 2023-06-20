package com.presentation.custom_view

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.RectF
import android.util.AttributeSet
import com.custom_view.base.QuizBaseCustomView
import com.common.R

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
        val radius = width / 2

        path.apply {
            reset()
            paint.color = context.getColor(R.color.blue_secondary_lightest)
            val rightRectF = RectF(width-radius, height-radius, width, height)
            val leftRectF = RectF(0f, height-radius, radius, height)

            moveTo(0f, 0f)
            lineTo(width, 0f)
            //draws arc at the right bottom side
            arcTo(rightRectF, 0f, 90f)
            //draws arc at the left bottom side
            arcTo(leftRectF, 90f, 90f)
            close()
        }
        canvas.drawPath(path, paint)
    }

    override fun onBind(canvas: Canvas) {
        drawBackground(canvas)
    }
}