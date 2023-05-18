package com.space.quiz_app.presentation.custom_view

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Path
import android.util.AttributeSet
import android.view.View
import com.space.quiz_app.R

class CustomQuestionBackground(
    context: Context,
    attrs: AttributeSet
) : BaseCustomView(context, attrs) {

    override fun drawBackground(canvas: Canvas) {
        val centerX1 = width / 4
        val centerX2 = width * 3 / 4
        val radius = width / 4
        val centerY = height - radius

        path.apply {
            reset()
            paint.color = context.getColor(R.color.blue_secondary_light)
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